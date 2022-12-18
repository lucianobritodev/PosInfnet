package br.com.infnet.locadoraveiculos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.domain.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
