package br.com.infnet.locadoraveiculos.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private static Map<Long, Veiculo> mapa = new HashMap<>();	
	private static Long id = 1l;

	public static void incluir(Veiculo veiculo) {
		veiculo.setId(id++);
		mapa.put(veiculo.getId(), veiculo);

		System.out.println(">>> incluindo veiculo " + veiculo.getId());
	}

	public static void excluir(Long id) {
		System.out.println(">>> excluindo veiculo " + id);
		mapa.remove(id);
	}

	public static Collection<Veiculo> obterLista(){
		return mapa.values();
	}

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "veiculo/listar";
	}
	
	@GetMapping
	public String redirectTelaLista() {
		return "redirect:/veiculo/listar";
	}
	
	@GetMapping("/{id}/excluir")
	public String exclusao(@PathVariable("id") Long id) {
		excluir(id);
		return "redirect:/veiculo/listar";
	}
}
