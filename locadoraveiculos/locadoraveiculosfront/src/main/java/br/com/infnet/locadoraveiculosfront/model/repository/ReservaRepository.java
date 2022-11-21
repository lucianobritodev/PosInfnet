package br.com.infnet.locadoraveiculosfront.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculosfront.model.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	@Query("from Reserva r where r.usuario.id = :userId")
	List<Reserva> findAllByUserId(Long userId);

}
