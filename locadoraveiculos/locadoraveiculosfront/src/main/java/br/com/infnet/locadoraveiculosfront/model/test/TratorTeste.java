package br.com.infnet.locadoraveiculosfront.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculosfront.model.domain.Trator;
import br.com.infnet.locadoraveiculosfront.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculosfront.model.domain.enuns.TipoTrator;
import br.com.infnet.locadoraveiculosfront.model.service.TratorService;
import br.com.infnet.locadoraveiculosfront.model.service.UsuarioService;

@Order(6)
@Component
public class TratorTeste implements ApplicationRunner {
	
	@Autowired
	private TratorService tratorService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Trator ##");
		
		Trator t1 = new Trator();
		t1.setNome("Massey Ferguson");
		t1.setCodigoChassi(1865412);
		t1.setCor("Verde");
		t1.setCombustivel(Combustivel.DIESEL);
		t1.setTipoTrator(TipoTrator.FLORESTAL);
		t1.setValor(650);
		t1.setMotor("390 cv");
		t1.setUsuario(usuarioService.obterUm(1l));
		System.out.println(t1);
		tratorService.salvar(t1);
		
		Trator t2 = new Trator();
		t2.setNome("New Holland");
		t2.setCodigoChassi(6358741);
		t2.setCor("Vermelho");
		t2.setCombustivel(Combustivel.DIESEL);
		t2.setTipoTrator(TipoTrator.ESTEIRA);
		t2.setValor(1000);
		t2.setMotor("440 cv");
		t2.setUsuario(usuarioService.obterUm(2l));
		System.out.println(t2);
		tratorService.salvar(t2);
		
		Trator t3 = new Trator();
		t3.setNome("John Deere");
		t3.setCodigoChassi(6354842);
		t3.setCor("Amarelo");
		t3.setCombustivel(Combustivel.ELETRICO);
		t3.setTipoTrator(TipoTrator.AGRICOLA);
		t3.setValor(1300);
		t3.setMotor("410 cv");
		t3.setUsuario(usuarioService.obterUm(2l));
		System.out.println(t3);
		tratorService.salvar(t3);
		
	}

}
