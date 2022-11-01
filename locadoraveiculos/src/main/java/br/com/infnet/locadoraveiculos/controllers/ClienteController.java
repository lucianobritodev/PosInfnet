package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@GetMapping("/listar")
	public String telaRoot() {
		return "cliente/listar";
	}
	
	@GetMapping("/")
	public String telaHome() {
		return "redirect:/cliente/listar";
	}
}
