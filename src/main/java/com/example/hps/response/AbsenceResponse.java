package com.example.hps.response;

import java.util.Date;


public class AbsenceResponse {
	private Long id_Absence;
	private String Type;
	private Date date_debut;
	private Date date_fin;
	private boolean justification=false;
	private UtilisateurResponse utilisateurResponse;
	public Long getId_Absence() {
		return id_Absence;
	}
	public void setId_Absence(Long id_Absence) {
		this.id_Absence = id_Absence;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public boolean isJustification() {
		return justification;
	}
	public void setJustification(boolean justification) {
		this.justification = justification;
	}
	public UtilisateurResponse getUtilisateurResponse() {
		return utilisateurResponse;
	}
	public void setUtilisateurResponse(UtilisateurResponse utilisateurResponse) {
		this.utilisateurResponse = utilisateurResponse;
	}
	
	
}
