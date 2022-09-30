package mx.com.octopus.app.services;

import java.math.BigDecimal;
import java.util.List;


import mx.com.octopus.app.calculo.Calculo;
import mx.com.octopus.app.models.hr.entity.TablaIsr;
import mx.com.octopus.app.models.hr.entity.TablaSubsidio;


public interface ITablaIsrService {
	
	public List<TablaIsr> findAll();
	
	public TablaIsr getTabuladorISR(Long anio,Long tipocalculo, BigDecimal importe);
	
	public Calculo calculaImpuesto(TablaIsr tablaIsr, TablaSubsidio tablaSubsidio,BigDecimal importe);
	
	public List<TablaIsr> getTablaIsr(Long anio, Long idTipoCalculo);
}
