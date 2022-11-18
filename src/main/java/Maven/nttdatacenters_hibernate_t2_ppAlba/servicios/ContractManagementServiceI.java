package Maven.nttdatacenters_hibernate_t2_ppAlba.servicios;


import java.util.List;

import Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia.Contract;

/**
 * Interfaz del servicio de la entidad Contrato
 * 
 * @author Alba
 *
 */
public interface ContractManagementServiceI {
	
	/**
	 * Inserción de nuevo contrato
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);
	
	/**
	 * Actualiza un contracto existente en la BBDD
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);
	
	/**
	 * Elimina un contrato existente
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);
	
	/**
	 * Obtiene un contrato por medio de la ID
	 * 
	 * @param contractId
	 * @return
	 */
	public Contract searchById(final Long contractId);
	
	/**
	 * Obtiene todos los contratos existentes
	 * 
	 * @return
	 */
	public List<Contract> searchAll();
}
