package com.wagner.demo.services.exceptions;

public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFound(Object id) {
		super("Id não encontrado: " + id);
	}

}
	