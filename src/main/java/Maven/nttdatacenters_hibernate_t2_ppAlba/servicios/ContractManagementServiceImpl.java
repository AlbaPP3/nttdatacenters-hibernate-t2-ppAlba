package Maven.nttdatacenters_hibernate_t2_ppAlba.servicios;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;


import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Contract;
import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.ContractDAOImpl;
/**
 * Implementacion del servicio de contratos
 * 
 * @author Alba
 *
 */

public class ContractManagementServiceImpl implements ContractManagementServiceI{
	/**ContractDAOImpl para podes utilizar los métodos*/
	ContractDAOImpl contractDao;
	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ContractManagementServiceImpl(final Session session) {
		contractDao = new ContractDAOImpl(session);
	}
	
	/**Métodos override heredados*/
	
	@Override
	public void insertNewContract(final Contract newContract) {
		if (newContract != null && newContract.getContractID() == null) {

			
			contractDao.insert(newContract);
		}

	}
	@Override
	public void updateContract(final Contract updatedContract) {
		if (updatedContract != null && updatedContract.getContractID() != null) {
			contractDao.update(updatedContract);
		}
		
	}
	@Override
	public void deleteContract(final Contract deletedContract) {
		if (deletedContract != null && deletedContract.getContractID() != null) { 
			contractDao.delete(deletedContract);
		}
	}
	@Override
	public Contract searchById(final Long contractId) {
		Contract contract = null;
		if (contractId != null) {
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}
	@Override
	public List<Contract> searchAll() {
		List<Contract> contractsList = new ArrayList<>();
		contractsList = contractDao.searchAll();

		return contractsList;
	}
}

	


	

