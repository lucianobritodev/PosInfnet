package br.com.infnet.locadoraveiculos.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioTeste implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("## Usuário ##");
		
		Usuario usr1 = new Usuario();
		usr1.setNome("Administrador");
		usr1.setEmail("admin@email.com");
		usr1.setSenha("123");
		usuarioService.salvar(usr1);
		
		Usuario usr2 = new Usuario();
		usr2.setNome("Luciano");
		usr2.setEmail("luciano@email.com");
		usr2.setSenha("123");
		usuarioService.salvar(usr2);
		
	}

}
