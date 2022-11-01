package br.com.infnet.locadoraveiculos.model.domain;

import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoMotor;

public abstract class Veiculo {
	
	private float valor;
	private int codigo;
	private String cor;
	private TipoMotor tipoMotor;
	
	public Veiculo() {}

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
	

	@Override
	public String toString() {
		return valor + ";" + codigo + ";" + cor + ";" + tipoMotor + ";";
	}

}
