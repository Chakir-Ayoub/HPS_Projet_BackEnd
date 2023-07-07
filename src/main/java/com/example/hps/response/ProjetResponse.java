package com.example.hps.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProjetResponse {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private LocalDate datelivraison;	
	List<DetailResponse> details=new ArrayList<>();
	
	public Long getIdprojet() {
		return idprojet;
	}
	public void setIdprojet(Long idprojet) {
		this.idprojet = idprojet;
	}
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
	public List<DetailResponse> getDetails() {
		return details;
	}
	public void setDetails(List<DetailResponse> details) {
		this.details = details;
	}

	
	
	
}
