package com.example.hps.request;

import java.time.LocalTime;

import com.example.hps.entity.Planification;

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
	private Planification  planification;
	
	
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
	public Planification getPlanification() {
		return planification;
	}
	public void setPlanification(Planification planification) {
		this.planification = planification;
	}
	
	
    
	
}
