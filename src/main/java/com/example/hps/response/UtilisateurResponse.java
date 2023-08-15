package com.example.hps.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class UtilisateurResponse {
	private Long idutilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String email;
	private int telephone;
	private List<AbsenceResponse> absences=new ArrayList<>();
	private List<SessionResponse> session;	

}
