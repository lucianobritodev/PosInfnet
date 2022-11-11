package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.controllers.VeiculoController;
import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Order(3)
@Component
public class VeiculoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Veículos ##");
		
		Trator v1 = new Trator();
		v1.setNome("Massey Ferguson");
		v1.setCodigoChassi(584651331);
		v1.setCor("Verde");
		v1.setCombustivel(Combustivel.DIESEL);
		v1.setTipoTrator(TipoTrator.FLORESTAL);
		v1.setValor(650);
		v1.setMotor("390 cv");
		System.out.println(v1);
		VeiculoController.incluir(v1);
		
		Carreta v2 = new Carreta();
		v2.setNome("Volvo");
		v2.setCapacidadeReboque(30000);
		v2.setCodigoChassi(17845552);
		v2.setCor("Amarelo");
		v2.setCombustivel(Combustivel.DIESEL);
		v2.setValor(300.0f);
		v2.setMotor("750 cv");
		System.out.println(v2);
		VeiculoController.incluir(v2);
		
		CarroPasseio v3 = new CarroPasseio();
		v3.setNome("Gol");
		v3.setAssentos(5);
		v3.setCodigoChassi(169775128);
		v3.setCor("Vermelho");
		v3.setCombustivel(Combustivel.FLEX);
		v3.setValor(100);
		v3.setMotor("77 cv");
		v3.setDirecaoHidraulica(false);
		System.out.println(v3);
		VeiculoController.incluir(v3);
		
	}

}
