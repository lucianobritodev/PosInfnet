package br.com.infnet.locadoraveiculos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.locadoraveiculos.model.domain.Reserva;
import br.com.infnet.locadoraveiculos.model.repository.ReservaRepository;
import br.com.infnet.locadoraveiculos.model.service.exception.IdentifierCanNotBeNullOrZeroException;
import br.com.infnet.locadoraveiculos.model.service.exception.ResourceNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Transactional(readOnly = true)
	public List<Reserva> obterTodos() {
		return reservaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Reserva obterUm(final Long id) throws ResourceNotFoundException, IdentifierCanNotBeNullOrZeroException {
		if(id == null || id == 0) throw new IdentifierCanNotBeNullOrZeroException("Identificador não pode ser zero ou nulo!");
		return reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva com identificador " + id + " não encontrado!"));
	}
	
	@Transactional
	public Reserva incluir(Reserva reserva) {
		try {
			reserva = reservaRepository.saveAndFlush(reserva);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		return reserva;
	}
	
	@Transactional
	public Reserva atualizar(final Long id, Reserva reserva) {

		try {			
			this.obterUm(id);
			reserva.setId(id);
			reserva = reservaRepository.saveAndFlush(reserva);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
		
		return reserva;
	}
	
	@Transactional
	public void excluir(final Long id) {
		try {			
			this.obterUm(id);
			reservaRepository.deleteById(id);
		} catch (ResourceNotFoundException | IdentifierCanNotBeNullOrZeroException e) {
			e.printStackTrace();
		}
	}
	
}
