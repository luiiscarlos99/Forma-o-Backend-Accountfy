package com.accountfy.livros.services.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RegistroNaoEncontradoException(Object id) {
		super("Registro não encontrado. ID: " + id);
	}
	
}
