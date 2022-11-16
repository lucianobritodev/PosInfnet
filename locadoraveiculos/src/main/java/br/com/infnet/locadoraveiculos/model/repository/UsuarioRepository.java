package br.com.infnet.locadoraveiculos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmailAndSenha(String email, String senha);
	
}
