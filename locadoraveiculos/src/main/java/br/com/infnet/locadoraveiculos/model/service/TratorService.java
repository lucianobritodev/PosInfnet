package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.repository.TratorRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class TratorService {

	@Autowired
	private TratorRepository tratorRepository;
	
	@Transactional(readOnly = true)
	public List<Trator> obterTodos() {
		return tratorRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Trator obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return tratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Trator com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Trator incluir(Trator trator) {
		try {
			trator = tratorRepository.saveAndFlush(trator);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		return trator;
	}
	
	@Transactional
	public Trator atualizar(final Long id, Trator trator) {

		try {			
			this.obterUm(id);
			trator.setId(id);
			trator = tratorRepository.saveAndFlush(trator);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return trator;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			tratorRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
