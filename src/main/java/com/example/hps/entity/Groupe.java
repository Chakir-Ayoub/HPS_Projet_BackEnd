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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
