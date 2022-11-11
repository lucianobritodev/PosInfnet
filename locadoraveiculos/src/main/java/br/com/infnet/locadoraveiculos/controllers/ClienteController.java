package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private static Map<Long, Cliente> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(Cliente cliente) {
		cliente.setId(id++);
		mapa.put(cliente.getId(), cliente);

		System.out.println(">>> incluindo cliente " + cliente.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo cliente " + id);
		mapa.remove(id);
	}

	public static Collection<Cliente> obterLista(){
		return mapa.values();
	}

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "cliente/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/cliente/listar";
	}
	
}
