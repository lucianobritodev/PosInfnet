package br.com.infnet.locadoraveiculosfront.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculosfront.model.domain.Carreta;

@Repository
public interface CarretaRepository extends JpaRepository<Carreta, Long> {

}
