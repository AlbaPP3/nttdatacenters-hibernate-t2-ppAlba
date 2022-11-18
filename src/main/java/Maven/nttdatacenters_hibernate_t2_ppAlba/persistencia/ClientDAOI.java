package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.util.List;

/**
 * DAO de la tabla/entidad Cliente
 * 
 * @author Alba
 *
 */
public interface ClientDAOI extends CommonDAOI<Client>{
	/**
	 * Método para buscar el cliente por el nombre
	 * 
	 * @param name Nombre del cliente
	 * @return
	 */
	public List<Client>searchByName(String name);
	
	/**
	 * Método para buscar el cliente por apellidos
	 * 
	 * @param firstSurName Primer apellido del cliente
	 * @param secondSurName Segundo Apellido del cliente
	 * @return
	 */
	public List<Client> searchBySurName(String firstSurName, String secondSurName);
}
