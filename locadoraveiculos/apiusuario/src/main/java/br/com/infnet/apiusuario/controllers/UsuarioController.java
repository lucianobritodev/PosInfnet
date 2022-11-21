package br.com.infnet.apiusuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.apiusuario.model.domain.Usuario;
import br.com.infnet.apiusuario.model.service.UsuarioService;
import br.com.infnet.apiusuario.model.service.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterTodos() {
		List<Usuario> usuarios = usuarioService.obterTodos();
		return  ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<?> obterUmPorId(@PathVariable("id") Long id) {
		Usuario usuario = null;
		try {
			usuario = usuarioService.obterUmPorId(id);			
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario incluir(@RequestBody Usuario usuario) {
		return usuarioService.incluir(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		try {		
			usuario = usuarioService.atualizar(id, usuario);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		try {
			usuarioService.obterUmPorId(id);
			usuarioService.excluir(id);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Recurso não pode ser excluido porque possui relacionamento(s)!");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro: O recurso não pôde ser excluido pois algo inexperado ocorreu!");
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/validar")
	public ResponseEntity<?> validar(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		Usuario usuario = null;
		try {		
			usuario = usuarioService.validar(email, senha);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(usuario);
	}
	
}
