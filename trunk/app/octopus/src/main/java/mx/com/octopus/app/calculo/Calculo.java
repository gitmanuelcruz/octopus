package mx.com.octopus.app.calculo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Calculo implements Serializable {

	private BigDecimal ingresoGravable;

	private BigDecimal limiteInferior;

	private BigDecimal diferencia;

	private BigDecimal tasa;

	private BigDecimal impuestoMarginal;

	private BigDecimal cuotaFija;

	private BigDecimal impuestoPrevio;

	private BigDecimal subsidioEmpleo;

	private BigDecimal impuestoRetener;

	private Long idTablaIsr;

	private Long anio;

	private Long idtablaSubsidio;

	public Long getIdTablaIsr() {
		return idTablaIsr;
	}

	public void setIdTablaIsr(Long idTablaIsr) {
		this.idTablaIsr = idTablaIsr;
	}

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Long getIdtablaSubsidio() {
		return idtablaSubsidio;
	}

	public void setIdtablaSubsidio(Long idtablaSubsidio) {
		this.idtablaSubsidio = idtablaSubsidio;
	}

	public BigDecimal getIngresoGravable() {
		return ingresoGravable;
	}

	public void setIngresoGravable(BigDecimal ingresoGravable) {
		this.ingresoGravable = ingresoGravable;
	}

	public BigDecimal getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(BigDecimal limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	public BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}

	public BigDecimal getTasa() {
		return tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	public BigDecimal getImpuestoMarginal() {
		return impuestoMarginal;
	}

	public void setImpuestoMarginal(BigDecimal impuestoMarginal) {
		this.impuestoMarginal = impuestoMarginal;
	}

	public BigDecimal getCuotaFija() {
		return cuotaFija;
	}

	public void setCuotaFija(BigDecimal cuotaFija) {
		this.cuotaFija = cuotaFija;
	}

	public BigDecimal getImpuestoPrevio() {
		return impuestoPrevio;
	}

	public void setImpuestoPrevio(BigDecimal impuestoPrevio) {
		this.impuestoPrevio = impuestoPrevio;
	}

	public BigDecimal getSubsidioEmpleo() {
		return subsidioEmpleo;
	}

	public void setSubsidioEmpleo(BigDecimal subsidioEmpleo) {
		this.subsidioEmpleo = subsidioEmpleo;
	}

	public BigDecimal getImpuestoRetener() {
		return impuestoRetener;
	}

	public void setImpuestoRetener(BigDecimal impuestoRetener) {
		this.impuestoRetener = impuestoRetener;
	}

	private static final long serialVersionUID = 1L;
}
