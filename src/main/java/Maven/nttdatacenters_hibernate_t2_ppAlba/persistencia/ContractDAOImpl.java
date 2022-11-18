package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;



import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Implementación DAO entidad/tabla Contrato
 * 
 * @author Alba
 *
 */
public class ContractDAOImpl extends CommonDAOImpl<Contract> implements ContractDAOI{
	
	private static final Logger LOG = LoggerFactory.getLogger(ContractDAOImpl.class);
	
	/**Sesión de conexión a BBDD*/
	private Session session;
	
	/**Constructor*/
	public ContractDAOImpl(Session session) {
		super(session);
		this.session = session;
	}			
	
}
