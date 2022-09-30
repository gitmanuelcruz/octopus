package mx.com.octopus.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping({"/login","/"})
	public String login(Model model) {
		
		model.addAttribute("titulo", "Login Generico");
		return "login";
	}
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		
		return "inicio";
	}
}
