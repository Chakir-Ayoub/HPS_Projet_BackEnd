package com.example.hps.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;

@Entity
public class Groupe implements Serializable{

	private static final long serialVersionUID = -3553270484426239443L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgroup;
	@Column(nullable = false,length = 35)
	private String nomgroupe;
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "groupe",orphanRemoval = true)
	private List<Utilisateur> utilisateurs;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "groupe",orphanRemoval = true)
	private List<Sous_Groupe> sous_Groupes;

	
	
	@Transactional
	public void AddUtilisateur(Utilisateur utilisateur,Groupe groupe) {
		utilisateurs.add(utilisateur);
		utilisateur.setGroupe(groupe);
	}
	
	@Transactional
	public void Removeutilisateur(Utilisateur utilisateur) {
	    Utilisateur utilisateurASupprimer = null;
	    for (Utilisateur u : utilisateurs) {
	        if (u.equals(utilisateur)) {
	            utilisateurASupprimer = u;
	            break;
	        }
	    }
	    if (utilisateurASupprimer != null) {
	        utilisateurs.remove(utilisateurASupprimer);
	    }
	}
	
	@Transactional
	public void AddSousGroupe(Sous_Groupe sous_Groupe,Groupe groupe) {
		sous_Groupes.add(sous_Groupe);
		sous_Groupe.setGroupe(groupe);
	}
	
	@Transactional
	public void Removesous_groupe(Sous_Groupe sous_Groupe) {
	    Sous_Groupe sousgroupeASupprimer = null;
	    for (Sous_Groupe s : sous_Groupes) {
	        if (s.equals(sous_Groupe)) {
	        	sousgroupeASupprimer = s;
	            break;
	        }
	    }
	    if (sousgroupeASupprimer != null) {
	    	sous_Groupes.remove(sousgroupeASupprimer);
	    }
	}

	
	public Groupe(Long idgroup, String nomgroupe, List<Utilisateur> utilisateurs, List<Sous_Groupe> sous_Groupes) {
		super();
		this.idgroup = idgroup;
		this.nomgroupe = nomgroupe;
		this.utilisateurs = utilisateurs;
		this.sous_Groupes = sous_Groupes;
	}

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Sous_Groupe> getSous_Groupes() {
		return sous_Groupes;
	}

	public void setSous_Groupes(List<Sous_Groupe> sous_Groupes) {
		this.sous_Groupes = sous_Groupes;
	}
	
	
	
	
}
