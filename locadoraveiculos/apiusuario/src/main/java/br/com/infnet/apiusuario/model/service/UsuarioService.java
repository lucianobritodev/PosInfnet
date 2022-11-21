package br.com.infnet.apiusuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.apiusuario.model.domain.Usuario;
import br.com.infnet.apiusuario.model.repository.UsuarioRepository;
import br.com.infnet.apiusuario.model.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.apiusuario.model.service.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public List<Usuario> obterTodos() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario obterUmPorId(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		
		if(id == null || id == 0) { 
			throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		}
		
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso "+ id + " não encontrado!"));
	}

	@Transactional
	public Usuario incluir(Usuario usuario) {
		try {
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			usuario = usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@Transactional
	public Usuario atualizar(Long id, Usuario usuario) {
		
		Usuario userDB = obterUmPorId(id);
		if(!userDB.getSenha().equals(usuario.getSenha())) {
			usuario.setSenha(encoder.encode(usuario.getSenha()));
		}

		usuario.setId(id);
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	@Transactional
	public void excluir(final Long id) throws DataIntegrityViolationException,
		ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		this.obterUmPorId(id);
		usuarioRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario != null && encoder.matches(senha, usuario.getSenha())) {
			return usuario;
		}
		return new Usuario();
	}
	
}
