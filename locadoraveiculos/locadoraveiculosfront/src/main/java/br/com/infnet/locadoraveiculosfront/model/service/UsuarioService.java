package br.com.infnet.locadoraveiculosfront.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculosfront.clients.IEnderecoClient;
import br.com.infnet.locadoraveiculosfront.clients.IUsuarioClient;
import br.com.infnet.locadoraveiculosfront.model.domain.Endereco;
import br.com.infnet.locadoraveiculosfront.model.domain.Usuario;
import br.com.infnet.locadoraveiculosfront.model.repository.UsuarioRepository;
import br.com.infnet.locadoraveiculosfront.model.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculosfront.model.service.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	@Autowired
	private IUsuarioClient usuarioClient;
	
	@Transactional(readOnly = true)
	public List<Usuario> obterTodos() {
		return usuarioClient.obterTodos();
	}

	@Transactional(readOnly = true)
	public Usuario obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return usuarioClient.obterUmPorId(id);
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
		try {
			usuario = usuarioClient.incluir(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			usuarioRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioClient.validar(email, senha);
		if(usuario != null) {
			return usuario;
		}
		return new Usuario();
	}
	
	
	public Endereco obterEnderecoPorCep(String cep) {
		return enderecoClient.obterEnderecoPorCep(cep);
	}
	
}
