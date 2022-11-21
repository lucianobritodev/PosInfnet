package br.com.infnet.locadoraveiculos.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("from Cliente c where c.usuario.id = :userId")
	List<Cliente> findAllByUserId(Long userId);
	Optional<Cliente> findByEmail(String email);
	Optional<Cliente> findByCpf(String cpf);

}
