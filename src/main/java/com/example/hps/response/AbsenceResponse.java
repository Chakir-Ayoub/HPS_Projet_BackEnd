package com.example.hps.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AbsenceResponse {
	private Long idAbsence;
	private String Type;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private boolean justification;
}
