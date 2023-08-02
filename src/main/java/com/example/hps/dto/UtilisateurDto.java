package com.example.hps.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.hps.entity.Session;

import lombok.Data;


@Data
public class UtilisateurDto {
	private Long idutilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String email;
	private String encryptionpassword;
	private int telephone;
	private List<AbsenceDto> absences=new ArrayList<>();
	private GroupeDto groupe ;
	private List<SessionDto> session;	
}
