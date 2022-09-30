package mx.com.octopus.app.models.hr.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TABLA_ISR")
public class TablaIsr implements Serializable {

	@Id
	@Column(name = "ID_TABLA_ISR")
	private Long idTablaIsr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EJERCICIO_FISCAL")
	@JsonBackReference
	private EjerciciosFiscales ejercicioFiscal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_CALCULO")
	@JsonBackReference
	private TiposCalculo tipoCalculo;

	@Column(name = "LIMITE_INFERIOR")
	@NotNull
	private BigDecimal limiteInferior;

	@Column(name = "LIMITE_SUPERIOR")
	@NotNull
	private BigDecimal limiteSuperior;

	@Column(name = "CUOTA_FIJA")
	@NotNull
	private BigDecimal cuotaFija;

	@Column(name = "PORCENTAJE_EXCEDENTE")
	@NotNull
	private BigDecimal porcentajeExcedente;

	public Long getIdTablaIsr() {
		return idTablaIsr;
	}

	public void setIdTablaIsr(Long idTablaIsr) {
		this.idTablaIsr = idTablaIsr;
	}

	public EjerciciosFiscales getEjercicioFiscal() {
		return ejercicioFiscal;
	}

	public void setEjercicioFiscal(EjerciciosFiscales ejercicioFiscal) {
		this.ejercicioFiscal = ejercicioFiscal;
	}

	public TiposCalculo getTipoCalculo() {
		return tipoCalculo;
	}

	public void setTipoCalculo(TiposCalculo tipoCalculo) {
		this.tipoCalculo = tipoCalculo;
	}

	public BigDecimal getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(BigDecimal limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	public BigDecimal getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(BigDecimal limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	public BigDecimal getCuotaFija() {
		return cuotaFija;
	}

	public void setCuotaFija(BigDecimal cuotaFija) {
		this.cuotaFija = cuotaFija;
	}

	public BigDecimal getPorcentajeExcedente() {
		return porcentajeExcedente;
	}

	public void setPorcentajeExcedente(BigDecimal porcentajeExcedente) {
		this.porcentajeExcedente = porcentajeExcedente;
	}

	private static final long serialVersionUID = 1L;
}
