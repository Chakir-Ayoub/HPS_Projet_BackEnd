package com.example.hps.request;

import java.util.Date;
import java.util.List;

import com.example.hps.entity.Groupe;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UtilisateurRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nom_utilisateur;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String prenom_utilisateur;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Date date_naiss;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Email(message = "Ce champs doit respecter la format email !")
	private String email;
	@Size(min = 8,message = "Ce champs doit avoir au moins 8 Caracteres !")
	@Size(max = 12,message = "Ce champs doit avoir au max 12 Caracteres !")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Ce chmps doit avoid des lettres en Maj et Minsc et Numero ")
	private String password;
	@Size(min = 10,message = "Ce champs doit avoir au moins 10 Caracteres !")
	@Size(max = 10,message = "Ce champs doit avoir au max 10 Caracteres !")
	private int telephone;
	
	private List<AbsenceRequest>  absences;
	
	private Groupe groupe;
	
	private SessionRequest session;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}



	public List<AbsenceRequest> getAbsences() {
		return absences;
	}

	public void setAbsences(List<AbsenceRequest> absences) {
		this.absences = absences;
	}


	public SessionRequest getSession() {
		return session;
	}

	public void setSession(SessionRequest session) {
		this.session = session;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	

	
	
}
