package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@GetMapping("/home")
	public String redirectTelaLista() {
		return "redirect:/";
	}
	
	@GetMapping("/")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("msgWelcome", "Seja bem-vindo!");
		return new ModelAndView("/home");
	}
	
}
