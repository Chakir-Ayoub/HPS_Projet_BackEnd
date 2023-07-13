package com.example.hps.dto;

import java.util.List;

import lombok.Data;

@Data
public class GroupeDto {
	
	private Long idgroup;
	private String nomgroupe;
	private List<Sous_GroupeDto> sous_Groupes;
	private List<UtilisateurDto> utilisateurs;
}
