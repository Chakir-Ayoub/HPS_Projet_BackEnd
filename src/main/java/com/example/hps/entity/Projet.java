package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Projet implements Serializable {

	private static final long serialVersionUID = -6994354253010287858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprojet;
	@Column(nullable = false,length = 35)
	private String nomprojet;
	@Column(nullable = false,length = 35)
	private String description;
	@Column(nullable = false)
	private LocalDate datedemarrage;
	@Column(nullable = false)
	private LocalDate datelivraison;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "projet")
	private List<Detail> details;

	public Projet(Long idprojet, String nomprojet, String description, LocalDate datedemarrage, LocalDate datelivraison,
			List<Detail> details) {
		super();
		this.idprojet = idprojet;
		this.nomprojet = nomprojet;
		this.description = description;
		this.datedemarrage = datedemarrage;
		this.datelivraison = datelivraison;
		this.details = details;
	}

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	
	
	
	
}
