package mx.com.octopus.app.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.octopus.app.calculo.Calculo;
import mx.com.octopus.app.models.hr.dao.IEjerciciosFiscalesDao;
import mx.com.octopus.app.models.hr.dao.ITiposCalculoDao;
import mx.com.octopus.app.models.hr.entity.EjerciciosFiscales;
import mx.com.octopus.app.models.hr.entity.TablaIsr;
import mx.com.octopus.app.models.hr.entity.TablaSubsidio;
import mx.com.octopus.app.models.hr.entity.TiposCalculo;
import mx.com.octopus.app.models.user.dao.ICatLanguagesDao;
import mx.com.octopus.app.models.user.dao.IDepartamentoDao;
import mx.com.octopus.app.models.user.dao.IPrivilegioDao;
import mx.com.octopus.app.models.user.entity.Departamento;
import mx.com.octopus.app.models.user.entity.Idioma;
import mx.com.octopus.app.models.user.entity.Privilegio;
import mx.com.octopus.app.services.ITablaIsrService;
import mx.com.octopus.app.services.ITablaSubsidioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(produces = "application/json", value = "/isr",headers = "Accept=application/json")
public class RestIsrController {

	// private Logger logger = LoggerFactory.getLogger(RestIsrController.class);

	@Autowired
	private ITiposCalculoDao tiposCalculoRepository;

	@Autowired
	private IEjerciciosFiscalesDao ejerciciosFiscalesRepository;

	@Autowired
	private ITablaIsrService tablaIsrService;

	@Autowired
	private ITablaSubsidioService tablaSubsidioService;

	private Calculo calculo;
	
	@Autowired
	private ICatLanguagesDao ilanguageDao;
	
	@Autowired
	private IDepartamentoDao depto;
	
	@Autowired
	private IPrivilegioDao privilegioDao;
	
	@GetMapping("/periodos")
	public List<TiposCalculo> getTiposCalculo() {
		return (List<TiposCalculo>) tiposCalculoRepository.findAll();
	}

	@PostMapping("/periodos")
	public List<TiposCalculo> getTiposCalculoPost() {
		return (List<TiposCalculo>) tiposCalculoRepository.findAll();
	}

	@GetMapping("/ejercicios")
	public List<EjerciciosFiscales> getEjerciciosFiscales() {
		return (List<EjerciciosFiscales>) ejerciciosFiscalesRepository.findAll();
	}

	@GetMapping("/tablaisr")
	public List<TablaIsr> getTablaIsr() {
		return tablaIsrService.findAll();
	}

	@GetMapping("/tablaSubsidio")
	public List<TablaSubsidio> getTablaSubsidio() {
		return tablaSubsidioService.findAll();
	}

	@PostMapping(value = "/getTabulador/{anio}/{tipoCalculo}/{importe}")
	public Calculo postTabulador(@PathVariable(value = "anio") Long anio,
			@PathVariable(value = "tipoCalculo") Long tipoCalculo,
			@PathVariable(value = "importe") BigDecimal importe) {

		TablaIsr tisr = tablaIsrService.getTabuladorISR(anio, tipoCalculo, importe);
		TablaSubsidio subsidio = tablaSubsidioService.getTabuladorSubsidio(anio, tipoCalculo, importe);

		calculo = tablaIsrService.calculaImpuesto(tisr, subsidio, importe);
		calculo.setAnio(anio);
		calculo.setIdTablaIsr(tisr.getIdTablaIsr());
		calculo.setIdtablaSubsidio(subsidio.getIdTablaSubsidio());

		return calculo;
	}

	@PostMapping(value = "/tabla/{anio}/{tipoCalculo}")
	public List<TablaIsr> getTablaIsr(@PathVariable(value = "anio") Long anio,
			@PathVariable(value = "tipoCalculo") Long tipoCalculo) {
		return tablaIsrService.getTablaIsr(anio, tipoCalculo);
	}
	
	@GetMapping("/departamento")
	public List<Departamento> getDeptos(){
		return (List<Departamento>) depto.findAll();
	}
	
	@GetMapping("/privilegios")
	public List<Privilegio> privilegios(){
		return (List<Privilegio>) privilegioDao.findAll();
	}
	
	@GetMapping("/idiomas")
	public List<Idioma> getIdiomas(){
		return (List<Idioma>) ilanguageDao.findAll();
	}
}
