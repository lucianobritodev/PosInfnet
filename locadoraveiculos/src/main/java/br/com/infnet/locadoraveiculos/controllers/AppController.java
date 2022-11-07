package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String telaLista() {
		return "home";
	}
	
	@GetMapping("/home")
	public String redirectTelaLista() {
		return "redirect:/";
	}
}
