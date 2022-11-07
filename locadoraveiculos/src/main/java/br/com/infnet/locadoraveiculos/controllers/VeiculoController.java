package br.com.infnet.locadoraveiculos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.Veiculo;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	@GetMapping("/listar")
	public String telaLista(Model model) {
		model.addAttribute("listagem", getListVeiculosMock());
		return "veiculo/listar";
	}
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/veiculo/listar";
	}
	
	private List<Veiculo> getListVeiculosMock() {
		List<Veiculo> veiculos = new ArrayList<>();

		Trator v1 = new Trator();
		v1.setNome("Massey Ferguson");
		v1.setCodigo(1);
		v1.setCor("Verde");
		v1.setCombustivel(Combustivel.DIESEL);
		v1.setTipoTrator(TipoTrator.FLORESTAL);
		v1.setValor(650);
		v1.setMotor("390 cv");
		
		Carreta v2 = new Carreta();
		v2.setNome("Volvo");
		v2.setCapacidadeReboque(30000);
		v2.setCodigo(1);
		v2.setCor("Amarelo");
		v2.setCombustivel(Combustivel.DIESEL);
		v2.setValor(300.0f);
		v2.setMotor("750 cv");
		
		CarroPasseio v3 = new CarroPasseio();
		v3.setNome("Gol");
		v3.setAssentos(5);
		v3.setCodigo(1);
		v3.setCor("Vermelho");
		v3.setCombustivel(Combustivel.FLEX);
		v3.setValor(100);
		v3.setMotor("77 cv");
		v3.setDirecaoHidraulica(false);
		
		veiculos.addAll(Arrays.asList(v1, v2, v3));
		
		return veiculos;
	}
}
