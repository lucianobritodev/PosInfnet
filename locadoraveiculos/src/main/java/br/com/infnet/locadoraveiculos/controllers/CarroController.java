package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	private static Map<Long, CarroPasseio> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(CarroPasseio carro) {
		carro.setId(id++);
		mapa.put(carro.getId(), carro);

		System.out.println(">>> incluindo carro " + carro.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo carro " + id);
		mapa.remove(id);
	}

	public static Collection<CarroPasseio> obterLista(){
		return mapa.values();
	}

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "carro/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carro/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/carro/listar";
	}

}
