package com.example.hps.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class PlanificationRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datePlanification;
	private List<SessionRequest> sessions;
	
	public LocalDate getDatePlanification() {
		return datePlanification;
	}
	public void setDatePlanification(LocalDate datePlanification) {
		this.datePlanification = datePlanification;
	}
	public List<SessionRequest> getSessions() {
		return sessions;
	}
	public void setSessions(List<SessionRequest> sessions) {
		this.sessions = sessions;
	}
	
	
	
	
}
