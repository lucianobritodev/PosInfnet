package br.com.infnet.locadoraveiculos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.locadoraveiculos.domain.entities.Trator;

@Repository
public interface TratorRepository extends JpaRepository<Trator, Long> {

}
