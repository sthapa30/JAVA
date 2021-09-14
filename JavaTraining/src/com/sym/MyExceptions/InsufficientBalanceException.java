package com.sym.MyExceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	
	String errorMessage = "Unknown exception";
	public InsufficientBalanceException(String message) {
		this.errorMessage = message;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
