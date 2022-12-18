package br.com.infnet.locadoraveiculos.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.domain.entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Query("from Veiculo v where v.usuario.id = :userId")
	List<Veiculo> findAllByUserId(Long userId);

}
