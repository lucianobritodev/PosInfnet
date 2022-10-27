package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;

@Component
public class CarretaTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Carreta c1 = new Carreta();
		c1.setCapacidadeReboque(30000);
		System.out.println(c1);
		
		Carreta c2 = new Carreta();
		c2.setCapacidadeReboque(50000);
		System.out.println(c2);
		
		
	}

}
