package br.com.infnet.locadoraveiculos.model.domain;

public class CarroPasseio extends Veiculo {

	private int assentos;
	
	public CarroPasseio() { }

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	@Override
	public String toString() {
		return assentos + ";" + super.toString();
	}
	
}
