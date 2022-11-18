package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Implementación DAO genérico
 * 
 * @author Alba
 *
 * 
 */

public abstract class CommonDAOImpl <T extends AbstractEntity> implements CommonDAOI<T>{	
	
	/**LOGGER*/
	private static final Logger LOG = LoggerFactory.getLogger(CommonDAOImpl.class);
	
	/**Tipo de clase*/
	private Class<T> entityClass;	
	
	/**Sesión de conexión a la BBDD*/
	protected final Session session;
	
	/**
	 * Constructor
	 * 
	 * @param session Sesión de conexión a la BBDD.
	 */
	@SuppressWarnings("unchecked")
	protected CommonDAOImpl (Session session) {
		setEntityClass((Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);		
		this.session = session;
		LOG.info("Inicializando Session y tipo de la clase");
	}
	
	@Override
	public void insert(final T paramT) {					
		
		/**Verificación de que la sesión a la BBDD está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		/**Inserción a la BBDD*/
		session.save(paramT);
		session.flush();
		
		/**Guardado/Commit en la BBDD*/
		session.getTransaction().commit();	
		LOG.debug("Creación de la entidad");																	
	}
	
	@Override
	public void update(final T paramT) {
		
		/**Verificación de que la sesión a la BBDD está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		/**Inserción a la BBDD*/
		session.saveOrUpdate(paramT);
		
		/**Guardado/Commit en la BBBDD*/
		session.getTransaction().commit();
		LOG.debug("Actualización de la entidad");
	}
	
	@Override
	public void delete(final T paramT) {

		/**Verificación de que la sesión a la BBDD está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		/**Inserción en la BBDD*/
		session.delete(paramT);

		/**Guardado/Commit en la BBDD*/
		session.getTransaction().commit();
		LOG.debug("Eliminación de la entidad");
	}

	@Override
	public T searchById(final Long id) {

		/**Verificación de que la sesión a la BBDD está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		LOG.debug(" Busqueda de entidad por ID");
		
		/**Busqueda por al ID que es la Primary Key*/
		return  session.get(this.entityClass, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		/**Verificación de que la sesión a la BBDD está abierta*/
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		LOG.debug("Lectura de todas las entidades de la tabla");
		
		/**Busqueda de todos los resgitros*/
		return  session.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * 
	 * @return entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
	/**
	 * 
	 * @param entityClass Tipo de la clase
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	
}

