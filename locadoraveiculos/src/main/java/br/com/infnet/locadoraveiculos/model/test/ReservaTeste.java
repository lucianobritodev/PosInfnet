package br.com.infnet.locadoraveiculos.model.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;

@Component
public class ReservaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva de Veículos ##");
		
		Reserva r1 = new Reserva();
		r1.setStatus(StatusReserva.FINALIZADO);
		r1.setDataReserva(LocalDateTime.now());
		r1.setDescricao("Cliente buscará o veículo a tarde");
		System.out.println(r1);
		
		Reserva r2 = new Reserva();
		r2.setStatus(StatusReserva.PENDENTE);
		r2.setDataReserva(LocalDateTime.now().plusHours(2));
		r2.setDescricao("Cliente virá na loja para passar o cartão");
		System.out.println(r2);
		
		Reserva r3 = new Reserva();
		r3.setStatus(StatusReserva.RECUSADO);
		r3.setDataReserva(LocalDateTime.now().plusDays(-2).plusHours(3));
		r3.setDescricao("Cliente não possui limite no cartão");
		System.out.println(r3);
	}

}
