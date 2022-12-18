package br.com.infnet.locadoraveiculos.domain.entities.enuns;

public enum TipoTrator {
	
	ESTEIRA(1),
	FLORESTAL(2),
	AGRICOLA(3);

	private int value;
	
	TipoTrator(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}

}
