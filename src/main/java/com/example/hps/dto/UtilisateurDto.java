package com.example.hps.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class UtilisateurDto {
	private Long Id;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private Date date_naiss;
	private String email;
	private String encryptionpassword;
	private int telephone;
	private List<AbsenceDto> absences=new ArrayList<>();
	private List<GroupeDto> groupes =new ArrayList<>();
	private SessionDto sessionDto;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public List<GroupeDto> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<GroupeDto> groupes) {
		this.groupes = groupes;
	}
	public SessionDto getSessionDto() {
		return sessionDto;
	}
	public void setSessionDto(SessionDto sessionDto) {
		this.sessionDto = sessionDto;
	}
	
	
}
