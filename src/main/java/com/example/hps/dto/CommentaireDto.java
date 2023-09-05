package com.example.hps.dto;

import java.io.Serializable;
import java.time.LocalDate;


import lombok.*;

@Data
public class CommentaireDto implements Serializable {

	private static final long serialVersionUID = 6994339055387266050L;
	private Long id;
	private LocalDate date;
	private String comentaire;
	private ProjetDto projet;
}