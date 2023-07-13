package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Absence implements Serializable {

	private static final long serialVersionUID = -483323971372166910L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAbsence;
	@Column(length = 35,nullable = false)
	private String Type;
	@Column(nullable = false)
	private LocalDate date_debut;
	@Column(nullable = false)
	private LocalDate date_fin;
	@Column(nullable = false)
	private boolean justification;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	

	public Absence(Long idAbsence, String type, LocalDate date_debut, LocalDate date_fin, boolean justification,
			Utilisateur utilisateur) {
		super();
		this.idAbsence = idAbsence;
		Type = type;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.justification = justification;
		this.utilisateur = utilisateur;
	}
	
	

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}



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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
