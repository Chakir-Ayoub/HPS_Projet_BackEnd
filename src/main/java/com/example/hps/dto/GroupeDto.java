package com.example.hps.dto;

import java.util.List;

public class GroupeDto {
	
	private Long idgroup;
	private String nomgroupe;
	private List<Sous_GroupeDto> sous_Groupes;
	private List<UtilisateurDto> utilisateurs;
	
	
	public List<UtilisateurDto> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<UtilisateurDto> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public List<Sous_GroupeDto> getSous_Groupes() {
		return sous_Groupes;
	}
	public void setSous_Groupes(List<Sous_GroupeDto> sous_Groupes) {
		this.sous_Groupes = sous_Groupes;
	}
	public Long getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(Long idgroup) {
		this.idgroup = idgroup;
	}
	public String getNomgroupe() {
		return nomgroupe;
	}
	public void setNomgroupe(String nomgroupe) {
		this.nomgroupe = nomgroupe;
	}	
	
}
