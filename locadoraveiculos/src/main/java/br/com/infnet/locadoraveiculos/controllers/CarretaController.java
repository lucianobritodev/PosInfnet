package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carreta")
public class CarretaController {

	@GetMapping("/listar")
	public String telaRoot() {
		return "carreta/listar";
	}
	
	@GetMapping("/")
	public String telaHome() {
		return "redirect:/carreta/listar";
	}
}
