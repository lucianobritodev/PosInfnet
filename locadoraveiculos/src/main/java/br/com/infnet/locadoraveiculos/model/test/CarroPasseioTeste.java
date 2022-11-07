package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

@Component
public class CarroPasseioTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Carro de Passeio ##");
		
		CarroPasseio cp1 = new CarroPasseio();
		cp1.setNome("Gol");
		cp1.setAssentos(5);
		cp1.setCodigo(1);
		cp1.setCor("Vermelho");
		cp1.setCombustivel(Combustivel.FLEX);
		cp1.setValor(100);
		cp1.setMotor("77 cv");
		cp1.setDirecaoHidraulica(false);
		System.out.println(cp1);
		
		CarroPasseio cp2 = new CarroPasseio();
		cp2.setNome("Volvo");
		cp2.setAssentos(7);
		cp2.setCodigo(2);
		cp2.setCor("Prata");
		cp2.setCombustivel(Combustivel.GAS_NATURAL);
		cp2.setValor(200);
		cp2.setDirecaoHidraulica(true);
		cp2.setMotor("230 cv");
		System.out.println(cp2);
		
		CarroPasseio cp3 = new CarroPasseio();
		cp3.setNome("Saveiro");
		cp3.setAssentos(2);
		cp3.setCodigo(3);
		cp3.setCor("Preto");
		cp3.setCombustivel(Combustivel.ALCOOL);
		cp3.setValor(100);
		cp3.setDirecaoHidraulica(true);
		cp3.setMotor("106 cv");
		System.out.println(cp3);
		
	}

}
