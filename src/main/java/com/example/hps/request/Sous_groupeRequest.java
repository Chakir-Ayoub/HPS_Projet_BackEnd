package com.example.hps.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Sous_groupeRequest {
	
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nom_sous_groupe;
	
	private GroupeRequest groupeRequest;

	public String getNom_sous_groupe() {
		return nom_sous_groupe;
	}

	public void setNom_sous_groupe(String nom_sous_groupe) {
		this.nom_sous_groupe = nom_sous_groupe;
	}

	public GroupeRequest getGroupeRequest() {
		return groupeRequest;
	}

	public void setGroupeRequest(GroupeRequest groupeRequest) {
		this.groupeRequest = groupeRequest;
	}
	
	
}
