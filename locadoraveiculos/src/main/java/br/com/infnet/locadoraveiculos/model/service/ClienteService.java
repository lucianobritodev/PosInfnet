package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.repository.ClienteRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
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
	public Cliente obterUmId(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com identificador " + id + " não encontrado!"));
	}
	
	@Transactional(readOnly = true)
	public Cliente obterUmPorEmail(final String email) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(email.equals("")) throw new IdentifierCanNotBeEmptyNullOrZeroException("Email não pode ser vazio ou nulo!");
		return clienteRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com email " + email + " não encontrado!"));
	}
	
	@Transactional(readOnly = true)
	public Cliente obterUmPorCpf(final String cpf) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(cpf.equals("")) throw new IdentifierCanNotBeEmptyNullOrZeroException("CPF não pode ser vazio ou nulo!");
		return clienteRepository.findByEmail(cpf)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com CPF " + cpf + " não encontrado!"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		try {
			cliente = clienteRepository.saveAndFlush(cliente);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUmId(id);
			clienteRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
