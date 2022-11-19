package br.com.infnet.locadoraveiculos.controllers;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;
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
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("statusList", StatusReserva.values());
		return new ModelAndView("/reserva/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView telaEditar(Model model, @PathVariable("id") Long id) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Reserva reserva = reservaService.obterUm(id);
		model.addAttribute("reserva", reserva);
		model.addAttribute("data", dtf.format(reserva.getDataReserva()));
		model.addAttribute("statusList", StatusReserva.values());
		return new ModelAndView("/reserva/cadastrar");
	}

	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("reserva") Reserva reserva) {
		boolean incluir = reserva.getId() == null ? true : false;
		reserva = reservaService.salvar(reserva);
		
		if(incluir) {			
			model.addAttribute("msgSuccess", "Reserva "+ reserva.getId() +" incluida com sucesso!");
		} else {
			model.addAttribute("msgSuccess", "Reserva "+ reserva.getId() +" alterada com sucesso!");
		}
		
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		reservaService.excluir(id);
		model.addAttribute("msgSuccess", "Reserva "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
 }
