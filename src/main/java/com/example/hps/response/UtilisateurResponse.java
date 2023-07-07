package com.example.hps.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class UtilisateurResponse {
	private Long Id;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private Date date_naiss;
	private String email;
	private int telephone;
	private List<AbsenceResponse> absencesResponses=new ArrayList<>();
	private List<GroupeResponse> groupesResponses =new ArrayList<>();
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
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public List<AbsenceResponse> getAbsencesResponses() {
		return absencesResponses;
	}
	public void setAbsencesResponses(List<AbsenceResponse> absencesResponses) {
		this.absencesResponses = absencesResponses;
	}
	public List<GroupeResponse> getGroupesResponses() {
		return groupesResponses;
	}
	public void setGroupesResponses(List<GroupeResponse> groupesResponses) {
		this.groupesResponses = groupesResponses;
	}
	
	
	
}
