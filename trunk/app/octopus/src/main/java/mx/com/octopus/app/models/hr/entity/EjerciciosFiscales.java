package mx.com.octopus.app.models.hr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EJERCICIOS_FISCALES")
public class EjerciciosFiscales implements Serializable {

	@Column(name = "ID_EJERCICIO_FISCAL")
	@Id
	private Long idEjercicioFiscal;

	@Column(name = "NOMBRE_EJERCICIO_FISCAL")
	@NotNull
	private String nombreEjercicioFiscal;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_EJERCICIO_FISCAL")
	private List<TablaIsr> tablasIsr;

	public EjerciciosFiscales() {
	}

	public List<TablaIsr> getTablasIsr() {
		return tablasIsr;
	}

	public void setTablasIsr(List<TablaIsr> tablasIsr) {
		this.tablasIsr = tablasIsr;
	}

	public Long getIdEjercicioFiscal() {
		return idEjercicioFiscal;
	}

	public void setIdEjercicioFiscal(Long idEjercicioFiscal) {
		this.idEjercicioFiscal = idEjercicioFiscal;
	}

	public String getNombreEjercicioFiscal() {
		return nombreEjercicioFiscal;
	}

	public void setNombreEjercicioFiscal(String nombreEjercicioFiscal) {
		this.nombreEjercicioFiscal = nombreEjercicioFiscal;
	}

	private static final long serialVersionUID = 1L;

}
