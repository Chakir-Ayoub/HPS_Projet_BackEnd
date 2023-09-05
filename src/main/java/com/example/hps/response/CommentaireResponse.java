package com.example.hps.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireResponse {
	private Long id;
	private LocalDate date;
	private String comentaire;
	private ProjetResponse projet;
}
