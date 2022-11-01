package br.com.infnet.locadoraveiculos.model.test;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.CarroPasseio;
import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Component
public class ReservaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva ##");
		
		Cliente c1 = new Cliente();
		c1.setCpf("001.025.356-01");
		c1.setEmail("jose@email.com");
		c1.setNome("Jose Pereira");
		
		Cliente c2 = new Cliente();
		c2.setCpf("073.024.356-09");
		c2.setEmail("maria@email.com");
		c2.setNome("Maria da Silva");
		
		Cliente c3 = new Cliente();
		c3.setCpf("192.027.311-01");
		c3.setEmail("joao@email.com");
		c3.setNome("João Pedro");
		
		Carreta v1 = new Carreta();
		v1.setCapacidadeReboque(30000);
		v1.setCodigo(1);
		v1.setCor("Amarelo");
		v1.setTipoMotor(TipoMotor.DIESEL);
		v1.setValor(300.0f);
		
		CarroPasseio v2 = new CarroPasseio();
		v2.setAssentos(5);
		v2.setCodigo(1);
		v2.setCor("Vermelho");
		v2.setTipoMotor(TipoMotor.FLEX);
		v2.setValor(100);
		
		Trator v3 = new Trator();
		v3.setCodigo(1);
		v3.setCor("Verde");
		v3.setTipoMotor(TipoMotor.DIESEL);
		v3.setTipoTrator(TipoTrator.FLORESTAL);
		v3.setValor(650);
		
		
		Reserva r1 = new Reserva(c2);
		r1.setStatus(StatusReserva.FINALIZADO);
		r1.setDescricao("Cliente buscará o veículo a tarde");
		r1.setVeiculos(Arrays.asList(v1, v2, v3));
		System.out.println(r1);
		
		Reserva r2 = new Reserva();
		r2.setStatus(StatusReserva.PENDENTE);
		r2.setDescricao("Cliente virá na loja para passar o cartão");
		r2.setVeiculos(Arrays.asList(v2, v3));
		System.out.println(r2);
		
		Reserva r3 = new Reserva(c3);
		r3.setStatus(StatusReserva.RECUSADO);
		r3.setDescricao("Cliente não possui limite no cartão");
		r3.setVeiculos(Arrays.asList(v1));
		System.out.println(r3);
	}

}
