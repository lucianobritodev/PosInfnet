package br.com.infnet.locadoraveiculos.model.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.domain.Veiculo;
import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;
import br.com.infnet.locadoraveiculos.model.service.ClienteService;
import br.com.infnet.locadoraveiculos.model.service.ReservaService;
import br.com.infnet.locadoraveiculos.model.service.UsuarioService;
import br.com.infnet.locadoraveiculos.model.service.VeiculoService;

@Order(7)
@Component
public class ReservaTeste implements ApplicationRunner {
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Reserva ##");
		
		Usuario u1 = usuarioService.obterUmPorId(1l);
		List<Veiculo> v1 = veiculoService.obterTodosPorUsuario(u1);
		
		Usuario u2 = usuarioService.obterUmPorId(1l);
		List<Veiculo> v2 = veiculoService.obterTodosPorUsuario(u2);
		
		Cliente c1 = clienteService.obterUmId(1l);
		Cliente c2 = clienteService.obterUmId(1l);
		
		Reserva r1 = new Reserva(c1);
		r1.setStatus(StatusReserva.FINALIZADO);
		r1.setDescricao("Cliente buscará o veículo a tarde");
		r1.setDiasReservados(3);
		r1.setUsuario(u1);
		r1.setVeiculos(v1);
		System.out.println(r1);
		reservaService.salvar(r1);
		
		Reserva r2 = new Reserva(c2);
		r2.setStatus(StatusReserva.PENDENTE);
		r2.setDescricao("Cliente virá na loja para passar o cartão");
		r2.setDiasReservados(3);
		r2.setUsuario(u2);
		r2.setVeiculos(v2);
		System.out.println(r2);
		reservaService.salvar(r2);
		
		Reserva r3 = new Reserva(c2);
		r3.setStatus(StatusReserva.RECUSADO);
		r3.setDescricao("Cliente não possui limite no cartão");
		r3.setDiasReservados(3);
		r3.setUsuario(u1);
		r3.setVeiculos(v1);
		System.out.println(r3);
		reservaService.salvar(r3);
		
	}

}
