package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Trator;

@Controller
@RequestMapping("/trator")
public class TratorController {
	
	private static Map<Long, Trator> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(Trator trator) {
		trator.setId(id++);
		mapa.put(trator.getId(), trator);

		System.out.println(">>> incluindo trator " + trator.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo trator " + id);
		mapa.remove(id);
	}

	public static Collection<Trator> obterLista(){
		return mapa.values();
	}

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "trator/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/trator/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/trator/listar";
	}
}
