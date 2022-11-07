package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

@Controller
@RequestMapping("/carreta")
public class CarretaController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListCarretasMock());
		return "carreta/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carreta/listar";
	}
	
	private List<Carreta> getListCarretasMock() {
		List<Carreta> carretas = new ArrayList<>();

		Carreta c1 = new Carreta();
		c1.setNome("Volvo");
		c1.setCapacidadeReboque(30000);
		c1.setCodigo(1);
		c1.setCor("Amarelo");
		c1.setCombustivel(Combustivel.DIESEL);
		c1.setValor(300.0f);
		c1.setMotor("750 cv");
		
		Carreta c2 = new Carreta();
		c2.setNome("Scania");
		c2.setCapacidadeReboque(50000);
		c2.setCodigo(2);
		c2.setCor("Azul");
		c2.setCombustivel(Combustivel.DIESEL);
		c2.setValor(700.0f);
		c2.setMotor("830 cv");
		
		Carreta c3 = new Carreta();
		c3.setNome("Iveco");
		c3.setCapacidadeReboque(10000);
		c3.setCodigo(3);
		c3.setCor("Vermelho");
		c3.setCombustivel(Combustivel.GAS_NATURAL);
		c3.setValor(900.0f);
		c3.setMotor("710 cv");
		
		carretas.addAll(Arrays.asList(c1, c2, c3));
		
		return carretas;
	}
}
