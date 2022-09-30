package mx.com.octopus.app.services;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.octopus.app.models.hr.dao.ITablaSubsidioDao;
import mx.com.octopus.app.models.hr.entity.TablaSubsidio;

@Service
public class TablaSubsidioServiceImpl implements ITablaSubsidioService {

	@Autowired
	private ITablaSubsidioDao tablaSubsidio;

	@Override
	@Transactional(readOnly = true)
	public List<TablaSubsidio> findAll() {
		return (List<TablaSubsidio>) tablaSubsidio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TablaSubsidio getTabuladorSubsidio(Long anio, Long tipoCalculo, BigDecimal importe) {
		return tablaSubsidio.getTabuladorSubsidio(anio, tipoCalculo, importe);
	}

}
