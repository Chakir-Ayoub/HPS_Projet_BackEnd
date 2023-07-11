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
	private Long idsousgroupe;
	@Column(nullable = false,length = 35)
	private String nomsousgroupe;
	
	@ManyToOne
	@JoinColumn(name = "groupe")
	private Groupe groupe;

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

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	
	
	
}
