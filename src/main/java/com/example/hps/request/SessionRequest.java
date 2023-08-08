package com.example.hps.request;

import java.time.LocalTime;

import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Planification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SessionRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomsession;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalTime heureD;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalTime heureF;
	private Planification  planification;
	private UtilisateurDto utilisateur;
}
