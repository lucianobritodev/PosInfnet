package br.com.infnet.locadoraveiculosfront.model.domain.enuns;

public enum StatusReserva {
	RECUSADO(1),
	PENDENTE(2),
	FINALIZADO(3);
	
	private int status;
	
	StatusReserva(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}


}
