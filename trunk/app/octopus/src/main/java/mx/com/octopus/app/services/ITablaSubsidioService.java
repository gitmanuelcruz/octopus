package mx.com.octopus.app.services;

import java.math.BigDecimal;
import java.util.List;

import mx.com.octopus.app.models.hr.entity.TablaSubsidio;

public interface ITablaSubsidioService {

	public List<TablaSubsidio> findAll();
	
	public TablaSubsidio getTabuladorSubsidio(Long anio,Long tipoCalculo,BigDecimal importe);
}
