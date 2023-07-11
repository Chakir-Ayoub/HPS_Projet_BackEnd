package com.example.hps.dto;

import java.time.LocalDate;
import java.util.List;



public class PlanificationDto {
	private Long idPlanification;
	private LocalDate datePlanification;
	private List<SessionDto> sessions;
	
	public Long getIdPlanification() {
		return idPlanification;
	}
	public void setIdPlanification(Long idPlanification) {
		this.idPlanification = idPlanification;
	}
	public LocalDate getDatePlanification() {
		return datePlanification;
	}
	public void setDatePlanification(LocalDate datePlanification) {
		this.datePlanification = datePlanification;
	}
	public List<SessionDto> getSessions() {
		return sessions;
	}
	public void setSessions(List<SessionDto> sessions) {
		this.sessions = sessions;
	}
	
	
	
}
