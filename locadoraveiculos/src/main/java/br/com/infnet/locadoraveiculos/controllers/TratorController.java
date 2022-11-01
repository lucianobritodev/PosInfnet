package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trator")
public class TratorController {

	@GetMapping("/listar")
	public String telaRoot() {
		return "trator/listar";
	}
	
	@GetMapping("/")
	public String telaHome() {
		return "redirect:/trator/listar";
	}
}
