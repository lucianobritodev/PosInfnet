package br.com.infnet.locadoraveiculos.domain.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.infnet.locadoraveiculos.domain.entities.enuns.TipoTrator;

@Entity
@Table(name = "tb_trator")
public class Trator extends Veiculo {

	@Enumerated(EnumType.ORDINAL)
	private TipoTrator tipoTrator;
	private Boolean pilotoAutomatico;

	public Trator() {
	}

	public TipoTrator getTipoTrator() {
		return tipoTrator;
	}

	public void setTipoTrator(TipoTrator tipoTrator) {
		this.tipoTrator = tipoTrator;
	}

	public Boolean getPilotoAutomatico() {
		return pilotoAutomatico;
	}

	public void setPilotoAutomatico(Boolean pilotoAutomatico) {
		this.pilotoAutomatico = pilotoAutomatico;
	}	
	
	@Override
	public String toString() {
		return tipoTrator + ";" + super.toString();
	}

}
