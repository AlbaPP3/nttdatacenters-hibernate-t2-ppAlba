package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Implementación DAO de la entidad/tabla Cliente
 * 
 * @author Alba
 *
 */
public class ClientDAOImpl extends CommonDAOImpl<Client> implements ClientDAOI{		
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	/**Sesión de conexión a la BBDD*/
	private Session session;
	
	/**Constructor*/
	public ClientDAOImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchBySurName(String firstSurName, String secondSurName){
		
		LOG.debug("Busqueda de cliente por Apellidos");
		
		/**Verificacion de que la sesion está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		/**Busca los clientes por los apellidos*/
		final List<Client> results = session.createQuery("FROM Customer WHERE firstLastName='"+firstSurName +"'AND secondLastName='"+ secondSurName+"'").list();
		return results;
}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {
		
		LOG.debug("Busqueda de cliente por Nombre");
		
		/**Verificacion de que la sesion está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		/**Busca los clientes por el nombre*/
		final List<Client> clientsList = session.createQuery("FROM Client WHERE name=" + name).list();
		return clientsList;
	}
	
}


