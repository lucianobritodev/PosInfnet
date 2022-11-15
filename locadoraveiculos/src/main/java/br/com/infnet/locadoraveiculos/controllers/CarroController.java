package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carro/listar";
	}

	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", carroService.obterTodos());
		return new ModelAndView("/carro/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		carroService.excluir(id);
		model.addAttribute("msgSuccess", "Carro "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}

}
