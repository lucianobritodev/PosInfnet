package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.controllers.CarretaController;
import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

@Order(5)
@Component
public class CarretaTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Carreta ##");
		
		Carreta c1 = new Carreta();
		c1.setNome("Volvo");
		c1.setCapacidadeReboque(30000);
		c1.setCodigoChassi(151364852);
		c1.setCor("Amarelo");
		c1.setCombustivel(Combustivel.DIESEL);
		c1.setValor(300.0f);
		c1.setMotor("750 cv");
		System.out.println(c1);
		CarretaController.incluir(c1);
		
		Carreta c2 = new Carreta();
		c2.setNome("Scania");
		c2.setCapacidadeReboque(50000);
		c2.setCodigoChassi(24365432);
		c2.setCor("Azul");
		c2.setCombustivel(Combustivel.DIESEL);
		c2.setValor(700.0f);
		c2.setMotor("830 cv");
		System.out.println(c2);
		CarretaController.incluir(c2);
		
		Carreta c3 = new Carreta();
		c3.setNome("Iveco");
		c3.setCapacidadeReboque(10000);
		c3.setCodigoChassi(463016383);
		c3.setCor("Vermelho");
		c3.setCombustivel(Combustivel.GAS_NATURAL);
		c3.setValor(900.0f);
		c3.setMotor("710 cv");
		System.out.println(c3);
		CarretaController.incluir(c3);
		
	}

}
