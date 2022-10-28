package br.com.infnet.locadoraveiculos.model.domain;

import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;

public abstract class Veiculo {
	
	private float valor;
	private int codigo;
	private String cor;
	private TipoMotor tipoMotor;
	
	private Reserva reserva;
	
	public Veiculo() {}
	
	public Veiculo(float valor, int codigo, String cor, TipoMotor tipoMotor) {
		this.valor = valor;
		this.codigo = codigo;
		this.cor = cor;
		this.tipoMotor = tipoMotor;
	}

	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public TipoMotor getTipoMotor() {
		return tipoMotor;
	}
	
	public void setTipoMotor(TipoMotor tipoMotor) {
		this.tipoMotor = tipoMotor;
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return valor + ";" + codigo + ";" + cor + ";" + tipoMotor + ";";
	}

}
