package com.example.hps.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sous_Groupe implements Serializable {


	private static final long serialVersionUID = -2269499074835694171L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sous_groupe;
	@Column(nullable = false,length = 35)
	private String nom_sous_groupe;
	
	@ManyToOne
	@JoinColumn(name = "id_groupe")
	private Groupe groupe;

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

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	
}
