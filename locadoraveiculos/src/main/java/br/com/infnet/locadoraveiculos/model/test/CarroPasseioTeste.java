package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;

@Component
public class CarroPasseioTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Carro de Passeio ##");
		
		CarroPasseio cp1 = new CarroPasseio();
		cp1.setAssentos(5);
		cp1.setCodigo(1);
		cp1.setCor("Vermelho");
		cp1.setTipoMotor(TipoMotor.FLEX);
		cp1.setValor(100);
		System.out.println(cp1);
		
		CarroPasseio cp2 = new CarroPasseio();
		cp2.setAssentos(7);
		cp2.setCodigo(2);
		cp2.setCor("Prata");
		cp2.setTipoMotor(TipoMotor.GAS_NATURAL);
		cp2.setValor(200);
		System.out.println(cp2);
		
		CarroPasseio cp3 = new CarroPasseio();
		cp3.setAssentos(2);
		cp3.setCodigo(3);
		cp3.setCor("Preto");
		cp3.setTipoMotor(TipoMotor.ALCOOL);
		cp3.setValor(100);
		System.out.println(cp3);
		
	}

}
