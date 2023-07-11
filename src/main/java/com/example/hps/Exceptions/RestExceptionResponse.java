package com.example.hps.Exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class RestExceptionResponse {
	private String title;
	private int errorNumber;
	private LocalDateTime date;
    private String message;
	//private Map<String, Object> errors = new HashMap<>();
    
    
	public String getTitle() {
		return title;
	}
	public RestExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestExceptionResponse(String title, int errorNumber, LocalDateTime date, String message) {
		super();
		this.title = title;
		this.errorNumber = errorNumber;
		this.date = date;
		this.message = message;
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
	
    
}

