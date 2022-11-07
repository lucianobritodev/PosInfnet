package br.com.infnet.locadoraveiculos.model.domain;

public class CarroPasseio extends Veiculo {

	private int assentos;
	private boolean direcaoHidraulica;
	
	public CarroPasseio() { }

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	
	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}

	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}

	@Override
	public String toString() {
		return assentos + ";" + direcaoHidraulica + ";" + super.toString();
	}
	
}
