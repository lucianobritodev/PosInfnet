package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Controller
@RequestMapping("/trator")
public class TratorController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListTratoresMock());
		return "trator/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/trator/listar";
	}
	
	private List<Trator> getListTratoresMock() {
		List<Trator> tratores = new ArrayList<>();

		Trator t1 = new Trator();
		t1.setNome("Massey Ferguson");
		t1.setCodigo(1);
		t1.setCor("Verde");
		t1.setCombustivel(Combustivel.DIESEL);
		t1.setTipoTrator(TipoTrator.FLORESTAL);
		t1.setValor(650);
		t1.setMotor("390 cv");
		
		Trator t2 = new Trator();
		t2.setNome("New Holland");
		t2.setCodigo(2);
		t2.setCor("Vermelho");
		t2.setCombustivel(Combustivel.DIESEL);
		t2.setTipoTrator(TipoTrator.ESTEIRA);
		t2.setValor(980);
		t2.setMotor("440 cv");
		
		Trator t3 = new Trator();
		t3.setNome("John Deere");
		t3.setCodigo(3);
		t3.setCor("Amarelo");
		t3.setCombustivel(Combustivel.ELETRICO);
		t3.setTipoTrator(TipoTrator.AGRICOLA);
		t3.setValor(1300);
		t3.setMotor("410 cv");
		
		tratores.addAll(Arrays.asList(t1, t2, t3));
		
		return tratores;
	}
}
