package mx.com.octopus.app.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.octopus.app.calculo.Calculo;
import mx.com.octopus.app.models.hr.dao.ITablaIsrDao;
import mx.com.octopus.app.models.hr.entity.TablaIsr;
import mx.com.octopus.app.models.hr.entity.TablaSubsidio;

@Service
public class TablaIsrServiceImpl implements ITablaIsrService {

	@Autowired
	private ITablaIsrDao tablaIsrDao;

	@Override
	@Transactional(readOnly = true)
	public List<TablaIsr> findAll() {
		return (List<TablaIsr>) tablaIsrDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TablaIsr getTabuladorISR(Long anio, Long tipocalculo, BigDecimal importe) {
		return tablaIsrDao.getTabuladorISR(anio, tipocalculo, importe);
	}

	@Override
	public Calculo calculaImpuesto(TablaIsr tablaIsr, TablaSubsidio tablaSubsidio, BigDecimal importe) {
		Calculo c = new Calculo();

		c.setIngresoGravable(importe);
		c.setLimiteInferior(tablaIsr.getLimiteInferior());
		c.setCuotaFija(tablaIsr.getCuotaFija());
		c.setDiferencia(importe.subtract(tablaIsr.getLimiteInferior()));
		c.setTasa(tablaIsr.getPorcentajeExcedente());

		BigDecimal impuestoMarginal = new BigDecimal(0);
		impuestoMarginal = importe.subtract(tablaIsr.getLimiteInferior())
				.multiply(tablaIsr.getPorcentajeExcedente().divide(new BigDecimal(100)));

		c.setImpuestoMarginal(impuestoMarginal);

		BigDecimal impuestoPrevio = new BigDecimal(0);
		impuestoPrevio = impuestoMarginal.add(tablaIsr.getCuotaFija());

		c.setImpuestoPrevio(impuestoPrevio);
		c.setSubsidioEmpleo(tablaSubsidio.getImporteSubsidio());
		c.setImpuestoRetener(impuestoPrevio.subtract(tablaSubsidio.getImporteSubsidio()));

		return c;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TablaIsr> getTablaIsr(Long anio, Long idTipoCalculo) {
		return tablaIsrDao.getTablaIsr(anio, idTipoCalculo);
	}
}
