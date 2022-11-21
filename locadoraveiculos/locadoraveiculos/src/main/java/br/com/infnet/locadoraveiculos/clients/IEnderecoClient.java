package br.com.infnet.locadoraveiculos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.locadoraveiculos.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoClient {

	@GetMapping(value = "/{cep}/json")
	Endereco obterEnderecoPorCep(@PathVariable("cep") String cep);
	
}
