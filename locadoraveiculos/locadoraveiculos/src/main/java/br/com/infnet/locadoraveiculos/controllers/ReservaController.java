package br.com.infnet.locadoraveiculos.controllers;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.infnet.locadoraveiculos.model.service.ClienteService;
import br.com.infnet.locadoraveiculos.model.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;
import br.com.infnet.locadoraveiculos.model.service.ReservaService;
import br.com.infnet.locadoraveiculos.utilities.Utility;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/reserva/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model,  @SessionAttribute("user") Usuario usuario) {
		List<Reserva> reservas = reservaService.obterTodosPorUsuario(usuario);
		
		if(reservas.isEmpty()) {
			model.addAttribute("msgInfo", "Não existe resevas cadastradas pelo usuario " + Utility.getFirstName(usuario.getNome()) + "!");
		}
		
		model.addAttribute("listagem", reservas);
		return new ModelAndView("/reserva/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("statusList", StatusReserva.values());
		model.addAttribute("veiculoLista", veiculoService.obterTodos());
		model.addAttribute("clienteLista", clienteService.obterTodos());
		return new ModelAndView("/reserva/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView telaEditar(Model model, @PathVariable("id") Long id) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Reserva reserva = reservaService.obterUm(id);
		model.addAttribute("reserva", reserva);
		model.addAttribute("data", dtf.format(reserva.getDataReserva()));
		model.addAttribute("statusList", StatusReserva.values());
		model.addAttribute("veiculoLista", reserva.getVeiculos());
		model.addAttribute("clienteLista", reserva.getCliente());
		return new ModelAndView("/reserva/cadastrar");
	}

	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("reserva") Reserva reserva, @SessionAttribute("user") Usuario usuario) {
		boolean incluir = reserva.getId() == null ? true : false;
		reserva.setUsuario(usuario);
		reserva = reservaService.salvar(reserva);

		String mensagem = incluir ? "Reserva "+ reserva.getId() +" incluido com sucesso!" : "Reserva "+ reserva.getId() +" alterado com sucesso!";
		model.addAttribute("msgSuccess", mensagem);
		return this.telaLista(model, usuario);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model, @SessionAttribute("user") Usuario usuario) {
		reservaService.excluir(id);
		model.addAttribute("msgSuccess", "Reserva "+ id +" excluido com sucesso!");
		return this.telaLista(model, usuario);
	}
	
 }
