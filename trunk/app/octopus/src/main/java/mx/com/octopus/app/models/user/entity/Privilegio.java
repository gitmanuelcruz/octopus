package mx.com.octopus.app.models.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CAT_PRIVILEGES")
public class Privilegio implements Serializable {

	@Id
	@Column(name = "PRIVILEGE_ID")
	private Long privilegioId;

	@Column(name = "PRIVILEGE_CODE")
	private String privilegioCodigo;

	@Column(name = "PRIVILEGE_NAME")
	private String privilegioNombre;

	@Column(name = "PRIVILEGE_PATH")
	private String privilegioPath;

	@Column(name = "PRIVILEGE_TYPE")
	private String privilegioTipo;

	@Column(name = "PRIVILEGE_ICON")
	private String privilegioIcono;

	@Column(name = "ORDER_NUM")
	private Integer numOrden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIVILEGE_PARENT_ID", insertable = false, updatable = false)
	private Privilegio privilegioPadre;

	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "privilegioPadre")
	@JsonIgnore
	private List<Privilegio> privilegiosHijos;

	public Long getPrivilegioId() {
		return privilegioId;
	}

	public void setPrivilegioId(Long privilegioId) {
		this.privilegioId = privilegioId;
	}

	public String getPrivilegioCodigo() {
		return privilegioCodigo;
	}

	public void setPrivilegioCodigo(String privilegioCodigo) {
		this.privilegioCodigo = privilegioCodigo;
	}

	public String getPrivilegioNombre() {
		return privilegioNombre;
	}

	public void setPrivilegioNombre(String privilegioNombre) {
		this.privilegioNombre = privilegioNombre;
	}

	public String getPrivilegioPath() {
		return privilegioPath;
	}

	public void setPrivilegioPath(String privilegioPath) {
		this.privilegioPath = privilegioPath;
	}

	public String getPrivilegioTipo() {
		return privilegioTipo;
	}

	public void setPrivilegioTipo(String privilegioTipo) {
		this.privilegioTipo = privilegioTipo;
	}

	public String getPrivilegioIcono() {
		return privilegioIcono;
	}

	public void setPrivilegioIcono(String privilegioIcono) {
		this.privilegioIcono = privilegioIcono;
	}

	public Integer getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(Integer numOrden) {
		this.numOrden = numOrden;
	}

	public Privilegio getPrivilegioPadre() {
		return privilegioPadre;
	}

	public void setPrivilegioPadre(Privilegio privilegioPadre) {
		this.privilegioPadre = privilegioPadre;
	}

	public List<Privilegio> getPrivilegiosHijos() {
		return privilegiosHijos;
	}

	public void setPrivilegiosHijos(List<Privilegio> privilegiosHijos) {
		this.privilegiosHijos = privilegiosHijos;
	}

	private static final long serialVersionUID = 1L;

}
