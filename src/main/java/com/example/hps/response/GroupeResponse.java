package com.example.hps.response;

import java.util.ArrayList;
import java.util.List;



public class GroupeResponse {
	private Long id_group;
	private String nom_groupe;
	private UtilisateurResponse utilisateur;
	private List<Sous_GroupeResponse> sous_Groupes=new ArrayList<>();
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
	public UtilisateurResponse getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(UtilisateurResponse utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Sous_GroupeResponse> getSous_Groupes() {
		return sous_Groupes;
	}
	public void setSous_Groupes(List<Sous_GroupeResponse> sous_Groupes) {
		this.sous_Groupes = sous_Groupes;
	}
	
	
	
	
	
}
