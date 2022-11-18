package Maven.nttdatacenters_hibernate_t2_ppAlba;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Client;
import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Contract;
import Maven.nttdatacenters_hibernate_t2_ppAlba.servicios.ClientManagementServiceI;
import Maven.nttdatacenters_hibernate_t2_ppAlba.servicios.ClientManagementServiceImpl;
import Maven.nttdatacenters_hibernate_t2_ppAlba.servicios.ContractManagementServiceI;
import Maven.nttdatacenters_hibernate_t2_ppAlba.servicios.ContractManagementServiceImpl;


public class HibernateMain {
	
	private static final Logger LOG = LoggerFactory.getLogger(HibernateMain.class);
		
	public static void main( String[] args ) {	
		
		Session session ;
		Configuration con = new Configuration();
		SessionFactory sf = con.configure().buildSessionFactory();
		
		LOG.info("Configuración de la sesión generada correctamente");
		
		session = sf.openSession();
		
		LOG.info("Sesión abierta correctamente");
		
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);
		
		final String updateUser = "ALBA";
		final Date updateDate = new Date();
		
		final Contract contrato1 = new Contract();
		contrato1.setPrice("Rango1");
		contrato1.setUpdatedDate(updateDate);
		contrato1.setCreatedUser(updateUser);
		
		LOG.debug("Generación de contrato1");
		
		final Contract contrato2 = new Contract();
		contrato2.setPrice("Rango2");
		contrato2.setUpdatedDate(updateDate);
		contrato2.setCreatedUser(updateUser);
		
		LOG.debug("Generación de contrato2");
		
		final Client cliente1 = new Client();
		cliente1.setClientDni("7865425Z");
		cliente1.setName("Alejandro");
		cliente1.setFirstSurName("Tellez");
		cliente1.setSecondSurName("Rubio");
		cliente1.setUpdatedDate(updateDate);
		cliente1.setCreatedUser(updateUser);
		contrato1.setClient(cliente1);
		
		LOG.debug("Generación de cliente1");
		
		clientService.insertNewClient(cliente1);
		
		LOG.debug("Inserción de cliente1");
		
		contractService.insertNewContract(contrato1);
		contractService.insertNewContract(contrato2);
		
		LOG.debug("Inserción de contratos");
		
		session.close();
		LOG.info("Sesión cerrada correctamente");
	}
}
