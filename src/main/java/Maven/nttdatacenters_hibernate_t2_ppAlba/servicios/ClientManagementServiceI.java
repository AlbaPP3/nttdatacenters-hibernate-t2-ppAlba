package Maven.nttdatacenters_hibernate_t2_ppAlba.servicios;



import java.util.List;

import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Client;

/**
 * Interfaz del servicio de la entidad Cliente
 * 
 * @author Alba
 *
 */
public interface ClientManagementServiceI {
	/** Métodos CRUD*/
	
	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);
	
	/**
	 * Actualiza un cliente
	 * 
	 * @param updateClient
	 */
	public void updateClient(final Client updateClient);
	
	/**
	 * Elimina un cliente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);
	
	/**
	 * Obtiene un jugador mediante su ID
	 * 
	 * @param ClientID
	 * 
	 */
	public Client searchById(final Long ClientID);
	
	/**
	 * Obtiene un cliente por su nombre
	 * 
	 * @param name
	 * 
	 */
	public List<Client>searchByName(final String name);
	
	/**
	 * Obtiene todos los clientes existentes
	 * 
	 * @param name
	 * @return
	 */
	public List<Client>searchAll(final String name);
	
	/**
	 * Obtiene los clientes por sus apellidos
	 * 
	 * @param name
	 * @param firstSurName
	 * @param secondSurName
	 * @return
	 */
	List<Client> searchBySurname(final String firstSurName, final String secondSurName);
}
