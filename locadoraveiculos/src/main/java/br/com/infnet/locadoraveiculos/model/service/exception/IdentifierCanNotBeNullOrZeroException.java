package br.com.infnet.locadoraveiculos.model.service.exception;

public class IdentifierCanNotBeNullOrZeroException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IdentifierCanNotBeNullOrZeroException(String msg) {
		super(msg);
	}

}
