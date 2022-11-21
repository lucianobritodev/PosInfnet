package br.com.infnet.locadoraveiculosfront.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.infnet.locadoraveiculosfront.model.domain.Usuario;

@FeignClient(name = "${api.usario.name}", url = "${api.usario.host}", path = "${api.usario.path}")
public interface IUsuarioClient {

	@GetMapping
	public List<Usuario> obterTodos();
	
	@PostMapping("/validar")
	public Usuario validar(@RequestParam("email") String email, @RequestParam("senha") String senha) ;
	
	@GetMapping("/{id}")
	public  Usuario obterUmPorId(@PathVariable("id") Long id);

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario incluir(@RequestBody Usuario usuario);
	
	@PutMapping("/{id}")
	public Usuario atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario);
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Long id);
	
}
