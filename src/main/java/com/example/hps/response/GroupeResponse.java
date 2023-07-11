package com.example.hps.response;

import java.util.List;

public class GroupeResponse {
	private Long idgroup;
	private String nomgroupe;
	private List<Sous_GroupeResponse> sous_Groupes;
	private List<UtilisateurResponse> utilisateurs;
	
	public List<UtilisateurResponse> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<UtilisateurResponse> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Sous_GroupeResponse> getSous_Groupes() {
		return sous_Groupes;
	}

	public void setSous_Groupes(List<Sous_GroupeResponse> sous_Groupes) {
		this.sous_Groupes = sous_Groupes;
	}

	public String getNomgroupe() {
		return nomgroupe;
	}

	public void setNomgroupe(String nomgroupe) {
		this.nomgroupe = nomgroupe;
	}

	public Long getIdgroup() {
		return idgroup;
	}

	public void setIdgroup(Long idgroup) {
		this.idgroup = idgroup;
	}
}
