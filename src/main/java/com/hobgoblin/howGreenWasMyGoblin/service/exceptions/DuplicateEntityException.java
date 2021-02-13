package com.hobgoblin.howGreenWasMyGoblin.service.exceptions;

public class DuplicateEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateEntityException(String message) {
		super(message);
	}

}
