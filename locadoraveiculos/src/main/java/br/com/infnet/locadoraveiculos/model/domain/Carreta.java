package br.com.infnet.locadoraveiculos.model.domain;

import javax.persistence.Entity;

@Entity
public class Carreta extends Veiculo {
	
	private int capacidadeReboque;

	public Carreta() {
	}
	
	
	public int getCapacidadeReboque() {
		return capacidadeReboque;
	}

	public void setCapacidadeReboque(int capacidadeReboque) {
		this.capacidadeReboque = capacidadeReboque;
	}

	@Override
	public String toString() {
		return capacidadeReboque + ";" + super.toString();
	}
}
