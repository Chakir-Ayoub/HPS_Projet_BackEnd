package com.example.hps.Exceptions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class RestErrorsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpStatus;
	private Set<Map<String, Object>> errors = new HashSet<>();

	public RestErrorsException() {
		super();
	}

	public RestErrorsException(String message, HttpStatus httpStatus, Set<Map<String, Object>> errors) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
		this.errors = errors;
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

	public Set<Map<String, Object>> getErrors() {
		return errors;
	}

	public void setErrors(Set<Map<String, Object>> errors) {
		this.errors = errors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
