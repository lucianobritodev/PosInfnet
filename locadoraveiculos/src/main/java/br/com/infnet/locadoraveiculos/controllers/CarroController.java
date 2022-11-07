package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListCarrosMock());
		return "carro/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carro/listar";
	}
	
	private List<CarroPasseio> getListCarrosMock() {
		List<CarroPasseio> carros = new ArrayList<>();

		CarroPasseio cp1 = new CarroPasseio();
		cp1.setNome("Gol");
		cp1.setAssentos(5);
		cp1.setCodigo(1);
		cp1.setCor("Vermelho");
		cp1.setCombustivel(Combustivel.FLEX);
		cp1.setValor(100);
		cp1.setMotor("77 cv");
		cp1.setDirecaoHidraulica(false);
		
		CarroPasseio cp2 = new CarroPasseio();
		cp2.setNome("Volvo");
		cp2.setAssentos(7);
		cp2.setCodigo(2);
		cp2.setCor("Prata");
		cp2.setCombustivel(Combustivel.GAS_NATURAL);
		cp2.setValor(200);
		cp2.setDirecaoHidraulica(true);
		cp2.setMotor("230 cv");
		
		CarroPasseio cp3 = new CarroPasseio();
		cp3.setNome("Saveiro");
		cp3.setAssentos(2);
		cp3.setCodigo(3);
		cp3.setCor("Preto");
		cp3.setCombustivel(Combustivel.ALCOOL);
		cp3.setValor(100);
		cp3.setDirecaoHidraulica(true);
		cp3.setMotor("106 cv");
		
		carros.addAll(Arrays.asList(cp1, cp2, cp3));
		
		return carros;
	}
}
