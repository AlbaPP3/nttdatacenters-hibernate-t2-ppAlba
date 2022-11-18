package Maven.nttdatacenters_hibernate_t2_ppAlba.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Client;
import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.ClientDAOImpl;

/**
 * Implementación del servicio de cliente
 * 
 * @author Alba
 *
 */
public class ClientManagementServiceImpl  implements ClientManagementServiceI {
	
	/**Declaración de la clase ClientDAOImpl para poder usar susu métodos*/
	private ClientDAOImpl clienteDAO;
	
	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ClientManagementServiceImpl(final Session session) {
		clienteDAO = new ClientDAOImpl(session);
	}
	
	/**Métodos override heredados*/
	@Override
	public void insertNewClient(final Client newClient) {	
		if(newClient != null && newClient.getClientID() == null) {
			clienteDAO.insert(newClient);
		}
	}

	
	@Override
	public void updateClient(final Client updatedClient) {
		if (updatedClient != null && updatedClient.getClientID() != null) {
			clienteDAO.update(updatedClient);
		}

	}

	
	@Override
	public void deleteClient(final Client deletedClient) {
		if (deletedClient != null && deletedClient.getClientID() != null) {
			clienteDAO.delete(deletedClient);
		}

	}
	
	
	@Override
	public Client searchById(final Long clientID) {
		Client client = null;
		if (clientID != null) {
			client = clienteDAO.searchById(clientID);
		}

		return client;
	}
	
	
	@Override
	public List<Client> searchByName(final String name) {

		List<Client> clientsList = new ArrayList<>();
		if (StringUtils.isNotBlank(name)) {
			clientsList = clienteDAO.searchByName(name);

		return clientsList;
	}
		return clientsList;
	} 
	
	@Override
	public List<Client> searchAll(String name) {
		List<Client> clientsList = new ArrayList<>();
		clientsList = clienteDAO.searchAll();

		return clientsList;
	}
	
	@Override
	public List<Client> searchBySurname( String firstSurName, String secondSurName) {
		List<Client> results = new ArrayList<>();
		results = clienteDAO.searchBySurName(firstSurName, secondSurName);
		return results;
	}

	
}
