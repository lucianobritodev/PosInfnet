package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.repository.UsuarioRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	public List<Usuario> obterTodos() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Usuario incluir(Usuario usuario) {
		try {
			usuario = usuarioRepository.saveAndFlush(usuario);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@Transactional
	public Usuario atualizar(final Long id, Usuario usuario) {

		try {			
			this.obterUm(id);
			usuario.setId(id);
			usuario = usuarioRepository.saveAndFlush(usuario);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			usuarioRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
		if(usuario != null && senha.equals(usuario.getSenha())) {
			return usuario;
		}
		return null;
	}
	
}
