package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Carreta;
import br.com.infnet.locadoraveiculos.model.repository.CarretaRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class CarretaService {

	@Autowired
	private CarretaRepository carretaRepository;
	
	@Transactional(readOnly = true)
	public List<Carreta> obterTodos() {
		return carretaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Carreta obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return carretaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carreta com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Carreta incluir(Carreta carreta) {
		try {
			carreta = carretaRepository.saveAndFlush(carreta);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
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
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return carreta;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			carretaRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
