package br.com.infnet.locadoraveiculos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.domain.entities.Reserva;
import br.com.infnet.locadoraveiculos.domain.entities.Usuario;
import br.com.infnet.locadoraveiculos.domain.repository.ReservaRepository;
import br.com.infnet.locadoraveiculos.domain.service.exception.IdentifierCanNotBeEmptyNullOrZeroException;
import br.com.infnet.locadoraveiculos.domain.service.exception.ResourceNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Transactional(readOnly = true)
	public List<Reserva> obterTodos() {
		return reservaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> obterTodosPorUsuario(Usuario usuario) {
		return reservaRepository.findAllByUserId(usuario.getId());
	}

	@Transactional(readOnly = true)
	public Reserva obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeEmptyNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeEmptyNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Reserva salvar(Reserva reserva) {
		try {
			reserva = reservaRepository.saveAndFlush(reserva);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
		return reserva;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			reservaRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeEmptyNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
