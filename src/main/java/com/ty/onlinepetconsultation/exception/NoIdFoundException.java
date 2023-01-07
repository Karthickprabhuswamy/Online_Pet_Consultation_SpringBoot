package com.ty.onlinepetconsultation.exception;

public class NoIdFoundException extends RuntimeException{
	
	private String message="NOT FOUND";
	
	public NoIdFoundException() {
	}

	public NoIdFoundException(String message) {
		this.message = message;
	}
	
    public String getMessage() {
    	return message;
    }
	
	 

}
