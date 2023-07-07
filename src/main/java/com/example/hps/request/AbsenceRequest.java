package com.example.hps.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class AbsenceRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Type;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Date date_debut;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Date date_fin;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private boolean justification=false;
	private UtilisateurRequest utilisateurRequest;
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
	public UtilisateurRequest getUtilisateurRequest() {
		return utilisateurRequest;
	}
	public void setUtilisateurRequest(UtilisateurRequest utilisateurRequest) {
		this.utilisateurRequest = utilisateurRequest;
	}
	
	

}
