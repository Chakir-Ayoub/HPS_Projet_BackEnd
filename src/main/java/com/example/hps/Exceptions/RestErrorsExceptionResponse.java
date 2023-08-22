package com.example.hps.Exceptions;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;



public class RestErrorsExceptionResponse {
	private String title;
	private int errorNumber;
	private LocalDateTime date;
    private String message;
    private Set<Map<String, Object>> errors;
	public RestErrorsExceptionResponse(String title, int errorNumber, LocalDateTime date, String message,
			Set<Map<String, Object>> errors) {
		super();
		this.title = title;
		this.errorNumber = errorNumber;
		this.date = date;
		this.message = message;
		this.errors = errors;
	}
	public RestErrorsExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Set<Map<String, Object>> getErrors() {
		return errors;
	}
	public void setErrors(Set<Map<String, Object>> errors) {
		this.errors = errors;
	}
	
    
    
}



