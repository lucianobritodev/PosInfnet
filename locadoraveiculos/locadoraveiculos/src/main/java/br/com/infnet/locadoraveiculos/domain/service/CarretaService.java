package br.com.infnet.locadoraveiculos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.domain.entities.Carreta;
import br.com.infnet.locadoraveiculos.domain.repository.CarretaRepository;
import br.com.infnet.locadoraveiculos.domain.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculos.domain.service.exception.ResourceNotFoundException;

@Service
public class CarretaService {

	@Autowired
	private CarretaRepository carretaRepository;
	
	@Transactional(readOnly = true)
	public List<Carreta> obterTodos() {
		return carretaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Carreta obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return carretaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carreta com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Carreta salvar(Carreta carreta) {
		try {
			carreta = carretaRepository.saveAndFlush(carreta);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return carreta;
	}
	
	@Transactional
	public Carreta atualizar(final Long id, Carreta carreta) {

		try {			
			this.obterUm(id);
			carreta.setId(id);
			carreta = carretaRepository.saveAndFlush(carreta);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return carreta;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			carretaRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
