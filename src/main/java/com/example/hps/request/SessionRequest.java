package com.example.hps.request;

import java.time.LocalTime;
import java.util.List;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SessionRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomsession;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalTime heureD;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalTime heureF;
	private PlanificationRequest planification;
    private List<DetailsRequest> details;
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
	public PlanificationRequest getPlanification() {
		return planification;
	}
	public void setPlanification(PlanificationRequest planification) {
		this.planification = planification;
	}
	public List<DetailsRequest> getDetails() {
		return details;
	}
	public void setDetails(List<DetailsRequest> details) {
		this.details = details;
	}
	
    
	
}