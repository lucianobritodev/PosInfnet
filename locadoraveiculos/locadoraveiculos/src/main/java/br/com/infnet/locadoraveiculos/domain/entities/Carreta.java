package br.com.infnet.locadoraveiculos.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carreta")
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
