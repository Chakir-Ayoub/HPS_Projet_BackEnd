package com.example.hps.dto;

import java.time.LocalTime;
import java.util.List;
public class SessionDto {
	
	private Long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	private PlanificationDto planification;
	private List<DetailDto> details;
	
	public long getIdsession() {
		return idsession;
	}
	public void setIdsession(long idsession) {
		this.idsession = idsession;
	}
	public String getNomsession() {
		return nomsession;
	}
	public void setNomsession(String nomsession) {
		this.nomsession = nomsession;
	}
	public LocalTime getHeureD() {
		return heureD;
	}
	public void setHeureD(LocalTime heureD) {
		this.heureD = heureD;
	}
	public LocalTime getHeureF() {
		return heureF;
	}
	public void setHeureF(LocalTime heureF) {
		this.heureF = heureF;
	}
	public PlanificationDto getPlanification() {
		return planification;
	}
	public void setPlanification(PlanificationDto planification) {
		this.planification = planification;
	}
	public List<DetailDto> getDetails() {
		return details;
	}
	public void setDetails(List<DetailDto> details) {
		this.details = details;
	}
	
	
	
}
