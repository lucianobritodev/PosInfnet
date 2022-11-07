package br.com.infnet.locadoraveiculos.model.domain;

import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

public abstract class Veiculo {
	
	private String nome;
	private float valor;
	private int codigo;
	private String cor;
	private Combustivel combustivel;
	private String motor;
	
	public Veiculo() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return nome + ";" + valor + ";" + codigo + ";" + cor + ";" + combustivel + ";" + motor;
	}

}
