package com.example.hps.request;

import java.time.LocalDate;
import java.util.Date;

import com.example.hps.entity.Utilisateur;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class AbsenceRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Type;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate date_debut;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate date_fin;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private boolean justification;
	private Utilisateur utilisateur;
	
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
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	

}
