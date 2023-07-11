package com.example.hps.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class UtilisateurDto {
	private Long idutilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private Date date_naiss;
	private String email;
	private String encryptionpassword;
	private int telephone;
	private List<AbsenceDto> absences=new ArrayList<>();
	private GroupeDto groupe ;
	private SessionDto session;
	
	

	public Long getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}
	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}
	public Date getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncryptionpassword() {
		return encryptionpassword;
	}
	public void setEncryptionpassword(String encryptionpassword) {
		this.encryptionpassword = encryptionpassword;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public List<AbsenceDto> getAbsences() {
		return absences;
	}
	public void setAbsences(List<AbsenceDto> absences) {
		this.absences = absences;
	}
	
	
	public GroupeDto getGroupe() {
		return groupe;
	}
	public void setGroupe(GroupeDto groupe) {
		this.groupe = groupe;
	}
	public SessionDto getSession() {
		return session;
	}
	public void setSession(SessionDto session) {
		this.session = session;
	}

	
	
}
