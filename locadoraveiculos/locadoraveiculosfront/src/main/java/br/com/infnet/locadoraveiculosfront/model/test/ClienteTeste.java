package br.com.infnet.locadoraveiculosfront.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculosfront.model.domain.Cliente;
import br.com.infnet.locadoraveiculosfront.model.domain.Usuario;
import br.com.infnet.locadoraveiculosfront.model.service.ClienteService;
import br.com.infnet.locadoraveiculosfront.model.service.UsuarioService;


@Order(2)
@Component
public class ClienteTeste implements ApplicationRunner  {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Cadastro de Clientes ##");
		
		Usuario usr1 = usuarioService.obterUm(1l);
		Usuario usr2 = usuarioService.obterUm(2l);
		
		Cliente c1 = new Cliente();
		c1.setCpf("001.025.356-01");
		c1.setEmail("jose@email.com");
		c1.setNome("Jose Pereira");
		c1.setUsuario(usr1);
		System.out.println(c1);
		clienteService.salvar(c1);
		
		Cliente c2 = new Cliente();
		c2.setCpf("073.024.356-09");
		c2.setEmail("maria@email.com");
		c2.setNome("Maria da Silva");
		c2.setUsuario(usr1);
		System.out.println(c2);
		clienteService.salvar(c2);
		
		Cliente c3 = new Cliente();
		c3.setCpf("192.027.311-01");
		c3.setEmail("joao@email.com");
		c3.setNome("João Pedro");
		c3.setUsuario(usr2);
		System.out.println(c3);
		clienteService.salvar(c3);
		
	}

}
