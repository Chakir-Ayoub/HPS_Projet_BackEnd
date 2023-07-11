package com.example.hps.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Sous_groupeRequest {
	
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomsousgroupe;

	public String getNomsousgroupe() {
		return nomsousgroupe;
	}

	public void setNomsousgroupe(String nomsousgroupe) {
		this.nomsousgroupe = nomsousgroupe;
	}






	
}
