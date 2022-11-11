package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;

@Controller
@RequestMapping("/carreta")
public class CarretaController {
	
	private static Map<Long, Carreta> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(Carreta carreta) {
		carreta.setId(id++);
		mapa.put(carreta.getId(), carreta);

		System.out.println(">>> incluindo carreta " + carreta.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo carreta " + id);
		mapa.remove(id);
	}

	public static Collection<Carreta> obterLista(){
		return mapa.values();
	}

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "carreta/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carreta/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/carreta/listar";
	}
	
}
