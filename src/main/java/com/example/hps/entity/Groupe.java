package com.example.hps.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Groupe implements Serializable{

	private static final long serialVersionUID = -3553270484426239443L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_group;
	@Column(nullable = false,length = 35)
	private String nom_groupe;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "groupe",orphanRemoval = true)
	private List<Sous_Groupe> sous_Groupes;
	
	
	public Groupe(Long id_group, String nom_groupe) {
		super();
		this.id_group = id_group;
		this.nom_groupe = nom_groupe;
	}
	
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}


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
	
	
}
