package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

	@GetMapping
	public String telaRoot() {
		return "home";
	}
	
	@GetMapping("home")
	public String telaHome() {
		return "redirect:/";
	}
}
