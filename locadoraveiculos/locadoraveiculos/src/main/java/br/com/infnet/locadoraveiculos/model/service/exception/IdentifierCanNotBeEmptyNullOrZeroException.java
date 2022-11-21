package br.com.infnet.locadoraveiculos.model.service.exception;

public class IdentifierCanNotBeEmptyNullOrZeroException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IdentifierCanNotBeEmptyNullOrZeroException(String msg) {
		super(msg);
	}

}
