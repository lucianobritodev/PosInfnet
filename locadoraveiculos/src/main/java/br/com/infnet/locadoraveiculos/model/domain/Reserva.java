package br.com.infnet.locadoraveiculos.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private StatusReserva status;
	private String descricao;
	private LocalDateTime dataReserva;
	
	@Transient
	private Cliente cliente;
	@Transient
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Reserva() {
		dataReserva = LocalDateTime.now();
	}
	
	public Reserva(Cliente cliente) {
		this();
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return status + ";" + descricao + ";" + dataReserva + ";" + cliente + ";" + veiculos.size();
	}
}
