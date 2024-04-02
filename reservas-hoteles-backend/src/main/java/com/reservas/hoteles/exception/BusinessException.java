package com.reservas.hoteles.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends Exception {

	private static final long serialVersionUID = -8582277206660722157L;

	public BusinessException(Throwable ex) {
		super(ex.getMessage(), ex);
	}


}