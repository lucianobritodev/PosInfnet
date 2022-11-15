package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Carro;
import br.com.infnet.locadoraveiculos.model.repository.CarroRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Transactional(readOnly = true)
	public List<Carro> obterTodos() {
		return carroRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Carro obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return carroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carro com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Carro incluir(Carro carro) {
		try {
			carro = carroRepository.saveAndFlush(carro);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		return carro;
	}
	
	@Transactional
	public Carro atualizar(final Long id, Carro carro) {

		try {			
			this.obterUm(id);
			carro.setId(id);
			carro = carroRepository.saveAndFlush(carro);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return carro;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			carroRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
