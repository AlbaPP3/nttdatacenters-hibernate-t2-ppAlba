package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Clase de la Entidad Contrato
 * 
 * @author Alba
 *
 */
@Entity
@Table(name = "Contrato")
public class Contract extends AbstractEntity implements Serializable{
	
	/**Implementación serializable*/
	private static final long serialVersionUID = 1L;	
	
	/**Atributos*/
	private Long contractID;
	private String price;
	private Client client;
	private Date validity;
	private Date expiration;
	
	
	/**
	 * 
	 * @return contractID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_Contrato")
	public Long getContractID() {
		return contractID;
	}
	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}
	
	/**
	 * 
	 * @return price Precio del contrato
	 */
	@Column(name = "Precio", nullable = false)
	public String getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price Precio seleccionado
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return client Devuelve el cliente al que pertenece el contrato
	 */
	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	public Client getClient() {
		return client;
	}
	
	/**
	 * 
	 * @param client Asigna el cliente al que pertenece el contrato
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * 
	 * @return validity
	 */
	@Column(name = "Fecha_Inicio ")
	public Date getValidity() {
		return validity;
	}
	
	/**
	 * 
	 * @param validity Fecha validación
	 */
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
	/**
	 * 
	 * @return expiration
	 */
	@Column(name = "Fecha_Fin")
	public Date getExpiration() {
		return expiration;
	}
	
	/**
	 * 
	 * @param expiration Fecha expiración
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	@Override
	public String toString() {
		return "Contract [id =" + contractID + " Cliente =" + client +" vigencia =" + validity + ", caducidad =" + expiration + ", precioMensual ="
				+ price + "]";
	}
	
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}
	@Override
	@Transient
	public Long getId() {
		return this.contractID;
	}
	

	
}

