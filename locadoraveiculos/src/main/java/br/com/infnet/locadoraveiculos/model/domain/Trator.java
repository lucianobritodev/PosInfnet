package br.com.infnet.locadoraveiculos.model.domain;

import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

public class Trator extends Veiculo {
	
	private TipoTrator tipoTrator;
	
	public Trator() { }

	public TipoTrator getTipoTrator() {
		return tipoTrator;
	}

	public void setTipoTrator(TipoTrator tipoTrator) {
		this.tipoTrator = tipoTrator;	
	}

	@Override
	public String toString() {
		return tipoTrator + ";" + super.toString();
	}
	
}
