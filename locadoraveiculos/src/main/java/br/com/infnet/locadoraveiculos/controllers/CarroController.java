package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@GetMapping("/listar")
	public String telaRoot() {
		return "carro/listar";
	}
	
	@GetMapping("/")
	public String telaHome() {
		return "redirect:/carro/listar";
	}
}
