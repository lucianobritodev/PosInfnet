package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.Veiculo;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Component
public class VeiculoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva de Veículos ##");
		
		Trator t1 = new Trator();
		t1.setCodigo(1);
		t1.setCor("Verde");
		t1.setTipoMotor(TipoMotor.DIESEL);
		t1.setTipoTrator(TipoTrator.FLORESTAL);
		t1.setValor(650);
		System.out.println(t1);
		
		Carreta c1 = new Carreta();
		c1.setCapacidadeReboque(30000);
		c1.setCodigo(1);
		c1.setCor("Amarelo");
		c1.setTipoMotor(TipoMotor.DIESEL);
		c1.setValor(300.0f);
		System.out.println(c1);
		
		CarroPasseio cp1 = new CarroPasseio();
		cp1.setAssentos(5);
		cp1.setCodigo(1);
		cp1.setCor("Vermelho");
		cp1.setTipoMotor(TipoMotor.FLEX);
		cp1.setValor(100);
		System.out.println(cp1);
		
	}

}
