package com.hex.evaluation.exception;

public class InvalidUserNameException  extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

	

	public InvalidUserNameException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}
	
}
