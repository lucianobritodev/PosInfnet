package br.com.infnet.locadoraveiculos.model.domain;

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
		return "Carreta:" + capacidadeReboque+";";
	}
}
