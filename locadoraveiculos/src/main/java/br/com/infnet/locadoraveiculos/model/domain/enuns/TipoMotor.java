package br.com.infnet.locadoraveiculos.model.domain.enuns;

public enum TipoMotor {
	
	ELETRICO(1),
	GASOLINA(2),
	ALCOOL(3),
	DIESEL(4),
	FLEX(5),
	GAS_NATURAL(6);
	
	private int value;
	
	TipoMotor(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static Boolean contains(int value) {
		for(TipoMotor tipo : TipoMotor.values()) {
			if(tipo.value == value) {
				return true;
			}
		}
		return false;
	}
	
	public static TipoMotor getEnumByValue(int value) {
		for(TipoMotor tipo : TipoMotor.values()) {
			if(tipo.value == value) {
				return tipo;
			}
		}
		return null;
	}

}
