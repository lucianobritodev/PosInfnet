package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListClientesMock());
		return "cliente/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/cliente/listar";
	}
	
	private List<Cliente> getListClientesMock() {
		List<Cliente> clientes = new ArrayList<>();

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
		
		clientes.addAll(Arrays.asList(c1, c2, c3));
		
		return clientes;
	}
}
