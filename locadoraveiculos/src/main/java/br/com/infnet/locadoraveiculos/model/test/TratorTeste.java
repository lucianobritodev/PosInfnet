package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Component
public class TratorTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva de Trator ##");
		
		Trator t1 = new Trator();
		t1.setCodigo(1);
		t1.setCor("Verde");
		t1.setTipoMotor(TipoMotor.DIESEL);
		t1.setTipoTrator(TipoTrator.FLORESTAL);
		t1.setValor(650);
		System.out.println(t1);
		
		Trator t2 = new Trator();
		t2.setCodigo(2);
		t2.setCor("Vermelho");
		t2.setTipoMotor(TipoMotor.DIESEL);
		t2.setTipoTrator(TipoTrator.ESTEIRA);
		t2.setValor(980);
		System.out.println(t2);
		
		Trator t3 = new Trator();
		t3.setCodigo(3);
		t3.setCor("Amarelo");
		t3.setTipoMotor(TipoMotor.ELETRICO);
		t3.setTipoTrator(TipoTrator.AGRICOLA);
		t3.setValor(1300);
		System.out.println(t3);
		
	}

}
