package br.com.infnet.locadoraveiculos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.model.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
