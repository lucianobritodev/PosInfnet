package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carro;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.service.CarroService;

@Order(4)
@Component
public class CarroTeste implements ApplicationRunner {

	@Autowired
	private CarroService carroService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Carro ##");
		
		Carro cp1 = new Carro();
		cp1.setNome("Gol");
		cp1.setAssentos(5);
		cp1.setCodigoChassi(4652187);
		cp1.setCor("Vermelho");
		cp1.setCombustivel(Combustivel.FLEX);
		cp1.setValor(100);
		cp1.setMotor("77 cv");
		cp1.setDirecaoHidraulica(false);
		System.out.println(cp1);
		carroService.salvar(cp1);
		
		Carro cp2 = new Carro();
		cp2.setNome("Volvo");
		cp2.setAssentos(7);
		cp2.setCodigoChassi(7854122);
		cp2.setCor("Prata");
		cp2.setCombustivel(Combustivel.GAS_NATURAL);
		cp2.setValor(200);
		cp2.setDirecaoHidraulica(true);
		cp2.setMotor("230 cv");
		System.out.println(cp2);
		carroService.salvar(cp2);
		
		Carro cp3 = new Carro();
		cp3.setNome("Saveiro");
		cp3.setAssentos(2);
		cp3.setCodigoChassi(3695484);
		cp3.setCor("Preto");
		cp3.setCombustivel(Combustivel.ALCOOL);
		cp3.setValor(100);
		cp3.setDirecaoHidraulica(true);
		cp3.setMotor("106 cv");
		System.out.println(cp3);
		carroService.salvar(cp3);
		
	}

}
