package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.util.List;

/**
 * DAO genérico
 * 
 * @author Alba
 *
 * @param <T>
 */
public interface CommonDAOI<T> {		
	
	/**
	 * Inserta un registro en la BBDD.
	 * 
	 * @param paramT 
	 */
	public void insert(final T paramT);			
	
	/**
	 * Actualiza un registro en la BBDD
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * Localiza un resgistro por ID en la BBDD.
	 * 
	 * @param id
	 * @return
	 */
	public T searchById(final Long id);
	
	/**
	 * Búsqueda de todos los resgitros de la BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();
	
}

