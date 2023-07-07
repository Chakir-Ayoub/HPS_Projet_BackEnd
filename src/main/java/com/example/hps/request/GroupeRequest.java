package com.example.hps.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GroupeRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nom_groupe;
	
	private UtilisateurRequest utilisateurRequest;
	private List<Sous_groupeRequest>  groupeRequests;
	
	
	public String getNom_groupe() {
		return nom_groupe;
	}
	public void setNom_groupe(String nom_groupe) {
		this.nom_groupe = nom_groupe;
	}
	public UtilisateurRequest getUtilisateurRequest() {
		return utilisateurRequest;
	}
	public void setUtilisateurRequest(UtilisateurRequest utilisateurRequest) {
		this.utilisateurRequest = utilisateurRequest;
	}
	public List<Sous_groupeRequest> getGroupeRequests() {
		return groupeRequests;
	}
	public void setGroupeRequests(List<Sous_groupeRequest> groupeRequests) {
		this.groupeRequests = groupeRequests;
	}
	
	
	
	
}
