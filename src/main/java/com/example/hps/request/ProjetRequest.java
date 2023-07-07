package com.example.hps.request;

import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProjetRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomprojet;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String description;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datedemarrage;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datelivraison;
	
	
	private List<DetailsRequest> details;


	public String getNomprojet() {
		return nomprojet;
	}


	public void setNomprojet(String nomprojet) {
		this.nomprojet = nomprojet;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDatedemarrage() {
		return datedemarrage;
	}


	public void setDatedemarrage(LocalDate datedemarrage) {
		this.datedemarrage = datedemarrage;
	}


	public LocalDate getDatelivraison() {
		return datelivraison;
	}


	public void setDatelivraison(LocalDate datelivraison) {
		this.datelivraison = datelivraison;
	}


	public List<DetailsRequest> getDetails() {
		return details;
	}


	public void setDetails(List<DetailsRequest> details) {
		this.details = details;
	}





	
	
}
