package br.com.infnet.locadoraveiculos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.components.clients.IEnderecoClient;
import br.com.infnet.locadoraveiculos.domain.entities.Endereco;
import br.com.infnet.locadoraveiculos.domain.entities.Usuario;
import br.com.infnet.locadoraveiculos.domain.repository.UsuarioRepository;
import br.com.infnet.locadoraveiculos.domain.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculos.domain.service.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public List<Usuario> obterTodos() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario obterUmPorId(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com identificador " + id + " não encontrado!"));
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
		try {
			if(usuario.getId() != null) {
				Usuario userDB = usuarioRepository.findById(usuario.getId()).orElse(null);
				if(userDB != null && !userDB.getSenha().equals(usuario.getSenha())) {
					usuario.setSenha(encoder.encode(usuario.getSenha()));
				}
			} else {
				usuario.setSenha(encoder.encode(usuario.getSenha()));
			}
			usuario = usuarioRepository.saveAndFlush(usuario);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUmPorId(id);
			usuarioRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario != null && encoder.matches(senha, usuario.getSenha())) {
			return usuario;
		}
		return new Usuario();
	}
	
	
	public Endereco obterEnderecoPorCep(String cep) {
		return enderecoClient.obterEnderecoPorCep(cep);
	}
	
}
