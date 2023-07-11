package com.example.hps.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;


public class RestException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpStatus;
	
	public RestException() {
		super();
	}
	public RestException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public RestException(String message) {
		super(message);
		this.message = message;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

