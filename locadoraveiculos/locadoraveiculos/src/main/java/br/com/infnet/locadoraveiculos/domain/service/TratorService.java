package br.com.infnet.locadoraveiculos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.domain.entities.Trator;
import br.com.infnet.locadoraveiculos.domain.repository.TratorRepository;
import br.com.infnet.locadoraveiculos.domain.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculos.domain.service.exception.ResourceNotFoundException;

@Service
public class TratorService {

	@Autowired
	private TratorRepository tratorRepository;
	
	@Transactional(readOnly = true)
	public List<Trator> obterTodos() {
		return tratorRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Trator obterUmPorId(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return tratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Trator com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Trator salvar(Trator trator) {
		try {
			trator = tratorRepository.saveAndFlush(trator);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return trator;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUmPorId(id);
			tratorRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
