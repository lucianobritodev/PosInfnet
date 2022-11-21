package br.com.infnet.locadoraveiculosfront.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculosfront.model.domain.Carreta;
import br.com.infnet.locadoraveiculosfront.model.domain.Carro;
import br.com.infnet.locadoraveiculosfront.model.domain.Trator;
import br.com.infnet.locadoraveiculosfront.model.domain.Usuario;
import br.com.infnet.locadoraveiculosfront.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculosfront.model.domain.enuns.TipoTrator;
import br.com.infnet.locadoraveiculosfront.model.service.VeiculoService;

@Order(3)
@Component
public class VeiculoTeste implements ApplicationRunner {
	
	@Autowired
	private VeiculoService veiculoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Cadastro de Veículos ##");
		
		Usuario usr1 = new Usuario();
		usr1.setId(1l);
		
		Usuario usr2 = new Usuario();
		usr2.setId(2l);
		
		Trator v1 = new Trator();
		v1.setNome("Massey Ferguson");
		v1.setCodigoChassi(584651331);
		v1.setCor("Verde");
		v1.setCombustivel(Combustivel.DIESEL);
		v1.setTipoTrator(TipoTrator.FLORESTAL);
		v1.setValor(650);
		v1.setMotor("390 cv");
		v1.setUsuario(usr1);
		System.out.println(v1);
		veiculoService.incluir(v1);
		
		Carreta v2 = new Carreta();
		v2.setNome("Volvo");
		v2.setCapacidadeReboque(30000);
		v2.setCodigoChassi(17845552);
		v2.setCor("Amarelo");
		v2.setCombustivel(Combustivel.DIESEL);
		v2.setValor(300.0f);
		v2.setMotor("750 cv");
		v1.setUsuario(usr2);
		System.out.println(v2);
		veiculoService.incluir(v2);
		
		Carro v3 = new Carro();
		v3.setNome("Gol");
		v3.setAssentos(5);
		v3.setCodigoChassi(169775128);
		v3.setCor("Vermelho");
		v3.setCombustivel(Combustivel.FLEX);
		v3.setValor(100);
		v3.setMotor("77 cv");
		v3.setDirecaoHidraulica(false);
		v1.setUsuario(usr1);
		System.out.println(v3);
		veiculoService.incluir(v3);
		
	}

}
