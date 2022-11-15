package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.repository.ClienteRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public List<Cliente> obterTodos() {
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Cliente obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Cliente incluir(Cliente cliente) {
		try {
			cliente = clienteRepository.saveAndFlush(cliente);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@Transactional
	public Cliente atualizar(final Long id, Cliente cliente) {

		try {			
			this.obterUm(id);
			cliente.setId(id);
			cliente = clienteRepository.saveAndFlush(cliente);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			clienteRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
