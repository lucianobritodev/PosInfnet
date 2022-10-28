package br.com.infnet.locadoraveiculos.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;

public class Reserva {

	private StatusReserva status;
	private String descricao;
	private LocalDateTime dataReserva;
	
	private Cliente cliente;
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Reserva() { }
	
	public Reserva(StatusReserva status, String descricao, LocalDateTime dataReserva,
			Cliente cliente, Veiculo veiculo) {
		this.status = status;
		this.descricao = descricao;
		this.dataReserva = dataReserva;
		this.cliente = cliente;
		this.veiculos.add(veiculo);
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

	@Override
	public String toString() {
		return status + ";" + descricao + ";" + dataReserva + ";";
	}
}
