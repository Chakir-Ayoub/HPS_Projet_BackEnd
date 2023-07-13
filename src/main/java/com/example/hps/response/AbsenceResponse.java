package com.example.hps.response;

import java.time.LocalDate;
import java.util.Date;


public class AbsenceResponse {
	private Long idAbsence;
	private String Type;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private boolean justification;
	
	public Long getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(Long idAbsence) {
		this.idAbsence = idAbsence;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	public LocalDate getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDate getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}
	public boolean isJustification() {
		return justification;
	}
	public void setJustification(boolean justification) {
		this.justification = justification;
	}

	
	
}
