package com.example.hps.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.hps.entity.Session;

import lombok.Data;


@Data
public class UtilisateurResponse {
	private Long idutilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private LocalDate date_naiss;
	private String email;
	private int telephone;
	private List<AbsenceResponse> absences=new ArrayList<>();
	private Session session ;
}
