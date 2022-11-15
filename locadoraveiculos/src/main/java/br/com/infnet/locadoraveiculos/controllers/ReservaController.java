package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.service.ReservaService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/reserva/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", reservaService.obterTodos());
		return new ModelAndView("/reserva/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		reservaService.excluir(id);
		model.addAttribute("msgSuccess", "Reserva "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
 }
