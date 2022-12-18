package br.com.infnet.locadoraveiculos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.domain.entities.Usuario;
import br.com.infnet.locadoraveiculos.domain.entities.Veiculo;
import br.com.infnet.locadoraveiculos.domain.repository.VeiculoRepository;
import br.com.infnet.locadoraveiculos.domain.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculos.domain.service.exception.ResourceNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional(readOnly = true)
	public List<Veiculo> obterTodos() {
		return veiculoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Veiculo> obterTodosPorUsuario(Usuario usuario) {
		return veiculoRepository.findAllByUserId(usuario.getId());
	}

	@Transactional(readOnly = true)
	public Veiculo obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Veiculo incluir(Veiculo veiculo) {
		try {
			veiculo = veiculoRepository.saveAndFlush(veiculo);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return veiculo;
	}
	
	@Transactional
	public Veiculo atualizar(final Long id, Veiculo veiculo) {

		try {			
			this.obterUm(id);
			veiculo.setId(id);
			veiculo = veiculoRepository.saveAndFlush(veiculo);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return veiculo;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			veiculoRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
