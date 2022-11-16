package br.com.infnet.locadoraveiculos.model.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;

@Entity
@Table(name = "tb_veiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private float valor;
	private int codigoChassi;
	private String cor;
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;
	private String motor;
	
	public Veiculo() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public int getCodigoChassi() {
		return codigoChassi;
	}
	
	public void setCodigoChassi(int codigoChassi) {
		this.codigoChassi = codigoChassi;
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
		return id + ";" + nome + ";" + valor + ";" + codigoChassi + ";" + cor + ";" + combustivel + ";" + motor;
	}

}
