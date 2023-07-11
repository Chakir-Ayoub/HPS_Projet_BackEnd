package com.example.hps.dto;


public class Sous_GroupeDto {
	private Long idsousgroupe;
	private String nomsousgroupe;
	private GroupeDto groupe;

	
	public GroupeDto getGroupe() {
		return groupe;
	}
	public void setGroupe(GroupeDto groupe) {
		this.groupe = groupe;
	}
	public Long getIdsousgroupe() {
		return idsousgroupe;
	}
	public void setIdsousgroupe(Long idsousgroupe) {
		this.idsousgroupe = idsousgroupe;
	}
	public String getNomsousgroupe() {
		return nomsousgroupe;
	}
	public void setNomsousgroupe(String nomsousgroupe) {
		this.nomsousgroupe = nomsousgroupe;
	}

	
	
	
	
}
