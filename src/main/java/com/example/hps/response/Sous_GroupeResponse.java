package com.example.hps.response;




public class Sous_GroupeResponse {
	private Long id_sous_groupe;
	private String nom_sous_groupe;
	private GroupeResponse groupeResponse;
	
	
	public Long getId_sous_groupe() {
		return id_sous_groupe;
	}
	public void setId_sous_groupe(Long id_sous_groupe) {
		this.id_sous_groupe = id_sous_groupe;
	}
	public String getNom_sous_groupe() {
		return nom_sous_groupe;
	}
	public void setNom_sous_groupe(String nom_sous_groupe) {
		this.nom_sous_groupe = nom_sous_groupe;
	}
	public GroupeResponse getGroupeResponse() {
		return groupeResponse;
	}
	public void setGroupeResponse(GroupeResponse groupeResponse) {
		this.groupeResponse = groupeResponse;
	}
	
	
}
