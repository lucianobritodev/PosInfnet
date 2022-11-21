package br.com.infnet.locadoraveiculosfront.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculosfront.model.domain.Carro;
import br.com.infnet.locadoraveiculosfront.model.repository.CarroRepository;
import br.com.infnet.locadoraveiculosfront.model.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculosfront.model.service.exception.ResourceNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Transactional(readOnly = true)
	public List<Carro> obterTodos() {
		return carroRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Carro obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return carroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carro com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Carro salvar(Carro carro) {
		try {
			carro = carroRepository.saveAndFlush(carro);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
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
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return carro;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			carroRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
