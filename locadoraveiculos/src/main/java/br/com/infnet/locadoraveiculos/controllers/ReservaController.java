package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListReservaMock());
		return "reserva/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/reserva/listar";
	}
	
	private List<Reserva> getListReservaMock() {
		List<Reserva> reservas = new ArrayList<>();
		
		Cliente c1 = new Cliente();
		c1.setCpf("001.025.356-01");
		c1.setEmail("jose@email.com");
		c1.setNome("Jose Pereira");
		
		Cliente c2 = new Cliente();
		c2.setCpf("073.024.356-09");
		c2.setEmail("maria@email.com");
		c2.setNome("Maria da Silva");
		
		Cliente c3 = new Cliente();
		c3.setCpf("192.027.311-01");
		c3.setEmail("joao@email.com");
		c3.setNome("João Pedro");
		
		Reserva r1 = new Reserva(c2);
		r1.setStatus(StatusReserva.FINALIZADO);
		r1.setDescricao("Cliente buscará o veículo a tarde");
		
		Reserva r2 = new Reserva(c1);
		r2.setStatus(StatusReserva.PENDENTE);
		r2.setDescricao("Cliente virá na loja para passar o cartão");
		
		Reserva r3 = new Reserva(c3);
		r3.setStatus(StatusReserva.RECUSADO);
		r3.setDescricao("Cliente não possui limite no cartão");

		reservas.addAll(Arrays.asList(r1, r2, r3));
		
		return reservas;
	}
	
 }
