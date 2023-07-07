package com.example.hps.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 801544110262708169L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(length = 35 ,nullable = false)
	private String nom_utilisateur;
	@Column(length = 35 ,nullable = false)
	private String prenom_utilisateur;
	@Column(nullable = false)
	private Date date_naiss;
	@Column(length = 35 ,nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String encryptionpassword;
	@Column(nullable = false)
	private int telephone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateur",orphanRemoval = true)
	private List<Absence> absences=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateur",orphanRemoval = true)
	private List<Groupe> groupes =new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_session")
	private Session session;
	
	public Utilisateur(String nom_utilisateur, String prenom_utilisateur, Date date_naiss, String email,
			String encryptionpassword, int telephone, List<Absence> absences) {
		super();
		this.nom_utilisateur = nom_utilisateur;
		this.prenom_utilisateur = prenom_utilisateur;
		this.date_naiss = date_naiss;
		this.email = email;
		this.encryptionpassword = encryptionpassword;
		this.telephone = telephone;
		this.absences = absences;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}

	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptionpassword() {
		return encryptionpassword;
	}

	public void setEncryptionpassword(String encryptionpassword) {
		this.encryptionpassword = encryptionpassword;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	
	
}
