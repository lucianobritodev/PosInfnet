package br.com.infnet.locadoraveiculos.model.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;

@Entity
@Table(name = "tb_trator")
public class Trator extends Veiculo {
	
	@Enumerated(EnumType.ORDINAL)
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
