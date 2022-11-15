package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", clienteService.obterTodos());
		return new ModelAndView("/cliente/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		clienteService.excluir(id);
		model.addAttribute("msgSuccess", "Cliente "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
