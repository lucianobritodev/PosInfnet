package br.com.infnet.locadoraveiculos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;

@Repository
public interface CarretaRepository extends JpaRepository<Carreta, Long> {

}
