package com.example.hps.request;

import java.time.LocalDate;

import com.example.hps.entity.Projet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireRequest {
	private LocalDate date;
	private String comentaire;
	private Projet projet;	
}
