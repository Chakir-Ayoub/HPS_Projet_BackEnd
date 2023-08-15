package com.example.hps.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 801544110262708169L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idutilisateur;
	@Column(length = 35 ,nullable = false)
	private String nom_utilisateur;
	@Column(length = 35 ,nullable = false)
	private String prenom_utilisateur;

	@Column(length = 35 ,nullable = false,unique = true)
	private String email;
	private String encryptionpassword;
	@Column(nullable = false)
	private int telephone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateur",orphanRemoval = true)
	private List<Absence> absences;
	
	@JsonIgnore
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="id_Groupe")
	private Groupe groupe;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateur",orphanRemoval = true)
	private List<Session> session;
	
	
	
	@Transactional
	public void AjouterAbsence(Utilisateur utilisateur,Absence absence) {
		absences.add(absence);
		absence.setUtilisateur(utilisateur);
	}
	
	@Transactional
	public void SupperimerAbsence(Absence absence) {
		Absence absencesupprimer=null;
		for(Absence a: absences) {
			if(a.equals(absence)) {
				absencesupprimer=a;
				break;
			}
		}
		if(absencesupprimer!=null) {
			absences.remove(absencesupprimer)	;
		}
	}
	
	@Transactional
	public void AjouterSession(Utilisateur utilisateur,Session sessions) {
		session.add(sessions);
		sessions.setUtilisateur(utilisateur);
	}
	
	@Transactional
	public void SupperimerSession(Session sessions) {
		Session sessionsupperimer=null;
		for(Session s : session) {
			if(s.equals(sessions)) {
				sessionsupperimer=s;
				break;
			}
		}
		if(sessionsupperimer!=null) {
			session.remove(sessionsupperimer);
		}
	}
	

	
	
}
