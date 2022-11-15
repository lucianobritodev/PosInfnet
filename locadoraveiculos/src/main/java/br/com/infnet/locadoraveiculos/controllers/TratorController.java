package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.service.TratorService;

@Controller
@RequestMapping("/trator")
public class TratorController {
	
	@Autowired
	private TratorService tratorService;

	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/trator/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", tratorService.obterTodos());
		return new ModelAndView("/trator/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		tratorService.excluir(id);
		model.addAttribute("msgSuccess", "Trator "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
