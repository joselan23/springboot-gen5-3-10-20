package com.escalab.mediappbackend.exception;

public class ModeloNotFoundException extends RuntimeException {
	
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
