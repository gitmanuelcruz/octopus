package mx.com.octopus.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.octopus.app.models.hr.dao.IEjerciciosFiscalesDao;
import mx.com.octopus.app.models.hr.dao.ITablaIsrDao;
import mx.com.octopus.app.models.hr.dao.ITiposCalculoDao;
import mx.com.octopus.app.models.hr.entity.EjerciciosFiscales;
import mx.com.octopus.app.models.hr.entity.TablaIsr;
import mx.com.octopus.app.models.hr.entity.TiposCalculo;

@Controller
@RequestMapping("/isr")
public class IsrController {
	
	//private Logger logger = LoggerFactory.getLogger(IsrController.class);
	
	@Autowired
	private IEjerciciosFiscalesDao efiscales;
	
	@Autowired
	private ITiposCalculoDao tcalculo;
	
	@Autowired
	private ITablaIsrDao tablaIsr;
	
	@GetMapping("calculadora")
	public String calculadora(Model model) {
		List<EjerciciosFiscales> ef = (List<EjerciciosFiscales>) efiscales.findAll();
		List<TiposCalculo> tcalc = (List<TiposCalculo>) tcalculo.findAll();
		model.addAttribute("titulo","Calculadora ISR");
		model.addAttribute("anios", ef);
		model.addAttribute("periodos", tcalc);
		
		return "/isr/calculo";
	}
	
	@GetMapping(value="/listarTabla", produces={"application/json"})
	public @ResponseBody List<TablaIsr> listar(){
		return (List<TablaIsr>) tablaIsr.findAll();
	}
}
