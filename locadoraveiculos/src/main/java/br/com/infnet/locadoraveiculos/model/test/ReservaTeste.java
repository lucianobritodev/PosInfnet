package br.com.infnet.locadoraveiculos.model.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.domain.Carro;
import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;
import br.com.infnet.locadoraveiculos.model.service.ReservaService;

@Order(7)
@Component
public class ReservaTeste implements ApplicationRunner {
	
	@Autowired
	private ReservaService reservaService;

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
		v1.setNome("Volvo");
		v1.setCapacidadeReboque(30000);
		v1.setCodigoChassi(69548851);
		v1.setCor("Amarelo");
		v1.setCombustivel(Combustivel.DIESEL);
		v1.setValor(300.0f);
		v1.setMotor("750 cv");
		
		Trator v2 = new Trator();
		v2.setNome("Massey Ferguson");
		v2.setCodigoChassi(65845111);
		v2.setCor("Verde");
		v2.setCombustivel(Combustivel.DIESEL);
		v2.setTipoTrator(TipoTrator.FLORESTAL);
		v2.setValor(650);
		v2.setMotor("390 cv");
		
		Carro v3 = new Carro();
		v3.setNome("Gol");
		v3.setAssentos(5);
		v3.setCodigoChassi(198711325);
		v3.setCor("Vermelho");
		v3.setCombustivel(Combustivel.FLEX);
		v3.setValor(100);
		v3.setMotor("77 cv");
		v3.setDirecaoHidraulica(false);
		
		Reserva r1 = new Reserva(c2);
		r1.setStatus(StatusReserva.FINALIZADO);
		r1.setDescricao("Cliente buscará o veículo a tarde");
		r1.setVeiculos(Arrays.asList(v1, v2, v3));
		r1.setDiasReservados(3);
		System.out.println(r1);
		reservaService.salvar(r1);
		
		Reserva r2 = new Reserva(c1);
		r2.setStatus(StatusReserva.PENDENTE);
		r2.setDescricao("Cliente virá na loja para passar o cartão");
		r2.setVeiculos(Arrays.asList(v2, v3));
		r2.setDiasReservados(3);
		System.out.println(r2);
		reservaService.salvar(r2);
		
		Reserva r3 = new Reserva(c3);
		r3.setStatus(StatusReserva.RECUSADO);
		r3.setDescricao("Cliente não possui limite no cartão");
		r3.setVeiculos(Arrays.asList(v1));
		r3.setDiasReservados(3);
		System.out.println(r3);
		reservaService.salvar(r3);
		
	}

}
