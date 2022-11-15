package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.service.ClienteService;


@Order(2)
@Component
public class ClienteTeste implements ApplicationRunner  {
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Clientes ##");
		
		Cliente c1 = new Cliente();
		c1.setCpf("001.025.356-01");
		c1.setEmail("jose@email.com");
		c1.setNome("Jose Pereira");
		System.out.println(c1);
		clienteService.incluir(c1);
		
		Cliente c2 = new Cliente();
		c2.setCpf("073.024.356-09");
		c2.setEmail("maria@email.com");
		c2.setNome("Maria da Silva");
		System.out.println(c2);
		clienteService.incluir(c2);
		
		Cliente c3 = new Cliente();
		c3.setCpf("192.027.311-01");
		c3.setEmail("joao@email.com");
		c3.setNome("João Pedro");
		System.out.println(c3);
		clienteService.incluir(c3);
		
	}

}
