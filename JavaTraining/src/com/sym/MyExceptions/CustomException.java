package com.sym.MyExceptions;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode = "Unknown_Exception";

	public CustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;

	}

	public String getErrorCode() {
		return this.errorCode;
	}

}
