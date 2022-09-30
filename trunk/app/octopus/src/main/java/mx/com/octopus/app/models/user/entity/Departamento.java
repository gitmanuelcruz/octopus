package mx.com.octopus.app.models.user.entity;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "DEPARTMENTS")
public class Departamento implements Serializable {

	@Id
	@Column(name = "DEPARTMENT_ID")
	private Long departamentoId;

	@Column(name = "DEPARTMENT_NAME")
	private String departamentoNombre;

	@Column(name = "DEPARTMENT_ACTIVE")
	private int departamentoActivo;

	@Column(name = "COST_CENTER")
	private int centroCosto;

	public Departamento() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_PARENT_ID", referencedColumnName = "DEPARTMENT_ID")
	private Departamento departamentoPadre;

	@OneToMany(mappedBy = "departamentoPadre")
	@JsonIgnore
	private List<Departamento> subdeptos;

	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getDepartamentoNombre() {
		return departamentoNombre;
	}

	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
	}

	public int getDepartamentoActivo() {
		return departamentoActivo;
	}

	public void setDepartamentoActivo(int departamentoActivo) {
		this.departamentoActivo = departamentoActivo;
	}

	public int getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(int centroCosto) {
		this.centroCosto = centroCosto;
	}

	public Departamento getDepartamentoPadre() {
		return departamentoPadre;
	}

	public void setDepartamentoPadre(Departamento departamentoPadre) {
		this.departamentoPadre = departamentoPadre;
	}

	public List<Departamento> getSubdeptos() {
		return subdeptos;
	}

	public void setSubdeptos(List<Departamento> subdeptos) {
		this.subdeptos = subdeptos;
	}

	private static final long serialVersionUID = 1L;

}
