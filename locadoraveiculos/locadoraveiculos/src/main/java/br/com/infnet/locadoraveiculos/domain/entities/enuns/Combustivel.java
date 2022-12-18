package br.com.infnet.locadoraveiculos.domain.entities.enuns;

import java.util.ArrayList;
import java.util.List;

public enum Combustivel {
	
	ELETRICO(1),
	GASOLINA(2),
	ALCOOL(3),
	DIESEL(4),
	FLEX(5),
	GAS_NATURAL(6);
	
	private int value;
	
	Combustivel(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static Boolean contains(int value) {
		for(Combustivel tipo : Combustivel.values()) {
			if(tipo.value == value) {
				return true;
			}
		}
		return false;
	}
	
	public static Combustivel getEnumByValue(int value) {
		for(Combustivel tipo : Combustivel.values()) {
			if(tipo.value == value) {
				
				return tipo;
			}
		}
		return null;
	}
	
	public List<String> getNames() {
		List<String> stgs = new ArrayList<String>();
		for(Combustivel tipo : Combustivel.values()) {
			stgs.add(tipo.name());
		}
		return stgs;
	}

}
