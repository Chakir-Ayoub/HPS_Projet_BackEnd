package com.example.hps.request;

import java.time.LocalDate;

import com.example.hps.entity.Utilisateur;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AbsenceRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String type;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate date_debut;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate date_fin;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private boolean justification;
	private Utilisateur utilisateur;

}
