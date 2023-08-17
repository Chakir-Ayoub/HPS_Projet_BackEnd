package com.example.hps.response;

import java.util.ArrayList;
import java.util.List;

import com.example.hps.entity.Role;

import lombok.Data;


@Data
public class UtilisateurResponse {
	private Long idutilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String email;
	private int telephone;
	private String password;
	private List<AbsenceResponse> absences=new ArrayList<>();
	private List<SessionResponse> session;	
	private RoleResponse role;
}
