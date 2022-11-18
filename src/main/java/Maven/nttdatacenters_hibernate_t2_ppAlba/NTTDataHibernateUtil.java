package Maven.nttdatacenters_hibernate_t2_ppAlba;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NTTDataHibernateUtil {
	
	private static SessionFactory SESSION_FACTORY ;
		
	public NTTDataHibernateUtil() {
	}
	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		}catch(final Exception ex) {
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			
		}
	}
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
			
}
