package com.ty.onlinepetconsultation.exception;

public class InvalidCredentialsException extends RuntimeException{

	private String message="INVALID CREDENTIALS";
	
	public InvalidCredentialsException() {
	}
	
	public InvalidCredentialsException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
