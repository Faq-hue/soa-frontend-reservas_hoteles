package com.reservas.hoteles.exception;

public class BusinessException extends Exception {

	public BusinessException(Exception ex) {
		super(ex.getMessage(), ex);
	}
}