package com.example.hps.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class SessionDto {
	private long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	private PlanificationDto planification;
	private List<DetailDto> detailsDtos=new ArrayList<>();
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
	public List<DetailDto> getDetailsDtos() {
		return detailsDtos;
	}
	public void setDetailsDtos(List<DetailDto> detailsDtos) {
		this.detailsDtos = detailsDtos;
	}
	
	
	

	
	
	
}
