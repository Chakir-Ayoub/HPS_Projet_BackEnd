package com.example.hps.dto;



public class Sous_GroupeDto {
	private Long id_sous_groupe;
	private String nom_sous_groupe;
	private GroupeDto groupeDto;
	
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
	public GroupeDto getGroupeDto() {
		return groupeDto;
	}
	public void setGroupeDto(GroupeDto groupeDto) {
		this.groupeDto = groupeDto;
	}
	
	
}
