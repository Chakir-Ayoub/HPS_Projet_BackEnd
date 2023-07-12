package com.example.hps.request;


import com.example.hps.entity.Groupe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Sous_groupeRequest {
	
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomsousgroupe;
	private Groupe groupe;


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
