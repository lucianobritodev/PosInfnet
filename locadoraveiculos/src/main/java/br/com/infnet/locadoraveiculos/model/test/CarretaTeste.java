package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;

@Component
public class CarretaTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva de Carreta ##");
		
		Carreta c1 = new Carreta();
		c1.setCapacidadeReboque(30000);
		c1.setCodigo(1);
		c1.setCor("Amarelo");
		c1.setTipoMotor(TipoMotor.DIESEL);
		c1.setValor(300.0f);
		System.out.println(c1);
		
		Carreta c2 = new Carreta();
		c2.setCapacidadeReboque(50000);
		c2.setCodigo(2);
		c2.setCor("Azul");
		c2.setTipoMotor(TipoMotor.DIESEL);
		c2.setValor(700.0f);
		System.out.println(c2);
		
		Carreta c3 = new Carreta();
		c3.setCapacidadeReboque(10000);
		c3.setCodigo(3);
		c3.setCor("Vermelho");
		c3.setTipoMotor(TipoMotor.GAS_NATURAL);
		c3.setValor(900.0f);
		System.out.println(c3);
		
	}

}
