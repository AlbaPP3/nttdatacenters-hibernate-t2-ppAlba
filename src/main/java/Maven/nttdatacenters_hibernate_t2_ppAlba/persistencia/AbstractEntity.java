package Maven.nttdatacenters_hibernate_t2_ppAlba.persistencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Clase Entidad Abstracta de la que heredan todas las entidades de la BBDD.
 * 
 * @author Alba
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	/**Implementación Versión Serializable*/
	private static final long serialVersionUID = 1L;
	
	/**Actualización Usuario*/
	private String createdUser;
	
	/**Actualización Fecha*/
	private Date updatedDate;
	
	@Transient
	public abstract Long getId();

	/**
	 * 
	 * @return updatedUser
	 */
	@Column(name = "CREATE_USER", nullable = false)
	public String getCreatedUser() {
		return createdUser;
	}
	
	/**
	 * 
	 * @param updatedUser Usuario actualizado
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * 
	 * @return updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	/**
	 * 
	 * @param updatedDate Fecha Actualizada
	 */
	public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
	}
}

