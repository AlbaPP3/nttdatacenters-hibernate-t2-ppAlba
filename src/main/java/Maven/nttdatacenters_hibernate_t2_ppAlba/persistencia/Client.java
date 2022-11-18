package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase de la Entidad Cliente(tabla Cliente)
 * 
 * @author Alba
 *
 */
@Entity
@Table (name="Cliente")
public class Client extends AbstractEntity implements Serializable{
	
	/**Implementación Versión Serializable*/
	private static final long serialVersionUID = 1L;
	
	/**Identificador del cliente*/
	private Long clientID; 
	
	/**DNI del cliente*/
	private String dni;	
	
	/**Nombre del cliente*/
	private String name;
	
	/**Primer Apellido Cliente*/
	private String firstSurname;
	
	/**Segundo A pellido Cliente*/
	private String secondSurname;
	
	/**Contracto asociado*/
	private List<Contract> contract;
	
	/**
	 * 
	 * @return ClientID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ID_Cliente")
	public Long getClientID() {
		return clientID;
	}
	
	/**
	 * 
	 * @param ClientID Identificador del cliente
	 */
	public void setClientID(Long ClientID) {
		this.clientID = ClientID;
	}
	
	/**
	 * 
	 * @return ClientDni
	 */
	@Column(name = "DNI_Cliente", unique=true,nullable=false, length=9)
	public String getClientDni() {
		return dni;
	}
	
	/**
	 * 
	 * @param ClientDni DNI del cliente
	 */
	public void setClientDni(String ClientDni) {
		this.dni = ClientDni;
	}
	
	/**
	 * 
	 * @return name
	 */
	@Column(name = "Nombre_Cliente", nullable = false)
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name Nombre del cliente
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return firstSurName
	 */
	@Column(name = "Primer_Apellido", nullable = false)
	public String getFirstSurName() {
		return firstSurname;
	}
	
	/**
	 * 
	 * @param firstSurName Primer apellido del cliente
	 */
	public void setFirstSurName(String firstSurName) {
		this.firstSurname = firstSurName;
	}
	
	/**
	 * 
	 * @return secondSurName
	 */
	@Column(name = "Segundo_Apellido", nullable = false)
	public String getSecondSurName() {
		return secondSurname;
	}
	
	/**
	 * 
	 * @param secondSurName Segundo apellido del cliente
	 */
	public void setSecondSurName(String secondSurName) {
		this.secondSurname = secondSurName;
	}
	
	/**
	 * 
	 * @return contract
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client" )
	public List<Contract> getContract() {
		return contract;
	}
	
	/**
	 * 
	 * @param contract Contrato asociado al cliente
	 */
	public void setContract( List<Contract> contract) {
		this.contract = contract;
	}
	
	
	@Override
	public String toString() {
		return "Client [ClientID" + clientID + ", name=" + name + ", FirtSurName=" + firstSurname + ", SecodSurName" + secondSurname + ", DNI=" + dni + ", contract=" + contract + "]";
	}
	
	/**
	 * Método para el tipo Cliente
	 * 
	 * @return Client.class Clase Cliente
	 */
	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

	@Override
	@Transient
	public Long getId() {
		return this.clientID;
	}

	

}
	


