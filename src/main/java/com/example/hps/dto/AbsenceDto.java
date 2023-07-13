package com.example.hps.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AbsenceDto {
	private Long idAbsence;
	private String Type;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private boolean justification;
	private UtilisateurDto utilisateur;
}
