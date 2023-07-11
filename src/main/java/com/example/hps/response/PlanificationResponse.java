package com.example.hps.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.hps.dto.SessionDto;


public class PlanificationResponse {
	private Long idPlanification;
	private LocalDate datePlanification;
	private List<SessionResponse> sessions;

	
	public List<SessionResponse> getSessions() {
		return sessions;
	}
	public void setSessions(List<SessionResponse> sessions) {
		this.sessions = sessions;
	}
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
}
