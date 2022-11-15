package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.service.CarretaService;

@Controller
@RequestMapping("/carreta")
public class CarretaController {
	
	@Autowired
	private CarretaService carretaService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carreta/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", carretaService.obterTodos());
		return new ModelAndView("/carreta/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		carretaService.excluir(id);
		model.addAttribute("msgSuccess", "Carreta "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
