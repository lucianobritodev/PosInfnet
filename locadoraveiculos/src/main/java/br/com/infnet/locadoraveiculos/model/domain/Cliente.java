package br.com.infnet.locadoraveiculos.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nome;
	private String cpf;
	private String email;
	
	private List<Reserva> reservas = new ArrayList<>();
	
	public Cliente() { }
	
	public Cliente(String nome, String cpf, String email) { 
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	@Override
	public String toString() {
		return nome + ";" + cpf + ";" + email + ";";
	}

}
