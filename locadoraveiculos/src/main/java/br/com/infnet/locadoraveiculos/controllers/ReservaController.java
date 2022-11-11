package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Reserva;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	private static Map<Long, Reserva> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(Reserva reserva) {
		reserva.setId(id++);
		mapa.put(reserva.getId(), reserva);

		System.out.println(">>> incluindo reserva " + reserva.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo reserva " + id);
		mapa.remove(id);
	}

	public static Collection<Reserva> obterLista(){
		return mapa.values();
	}
	
	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "reserva/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/reserva/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/reserva/listar";
	}
	
 }
