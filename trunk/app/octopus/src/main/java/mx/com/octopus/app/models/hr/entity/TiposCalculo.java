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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TIPOS_CALCULO")
public class TiposCalculo implements Serializable {

	@Id
	@Column(name = "ID_TIPO_CALCULO")
	private Long idTipoCalculo;

	@Column(name = "NOMBRE_TIPO_CALCULO")
	private String nombreTipoCalculo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_TIPO_CALCULO")
	@JsonBackReference
	private List<TablaIsr> tablasIsr;

	public TiposCalculo() {
	}

	public List<TablaIsr> getTablasIsr() {
		return tablasIsr;
	}

	public void setTablasIsr(List<TablaIsr> tablasIsr) {
		this.tablasIsr = tablasIsr;
	}

	public Long getIdTipoCalculo() {
		return idTipoCalculo;
	}

	public void setIdTipoCalculo(Long idTipoCalculo) {
		this.idTipoCalculo = idTipoCalculo;
	}

	public String getNombreTipoCalculo() {
		return nombreTipoCalculo;
	}

	public void setNombreTipoCalculo(String nombreTipoCalculo) {
		this.nombreTipoCalculo = nombreTipoCalculo;
	}

	private static final long serialVersionUID = 1L;

}
