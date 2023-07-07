package com.example.hps.dto;

import java.util.List;



public class GroupeDto {
	
	private Long id_group;
	private String nom_groupe;
	private UtilisateurDto utilisateurDto;
	private List<Sous_GroupeDto> sous_GroupesDto;
	public Long getId_group() {
		return id_group;
	}
	public void setId_group(Long id_group) {
		this.id_group = id_group;
	}
	public String getNom_groupe() {
		return nom_groupe;
	}
	public void setNom_groupe(String nom_groupe) {
		this.nom_groupe = nom_groupe;
	}
	public UtilisateurDto getUtilisateurDto() {
		return utilisateurDto;
	}
	public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
		this.utilisateurDto = utilisateurDto;
	}
	public List<Sous_GroupeDto> getSous_GroupesDto() {
		return sous_GroupesDto;
	}
	public void setSous_GroupesDto(List<Sous_GroupeDto> sous_GroupesDto) {
		this.sous_GroupesDto = sous_GroupesDto;
	}
	
	
	
}
