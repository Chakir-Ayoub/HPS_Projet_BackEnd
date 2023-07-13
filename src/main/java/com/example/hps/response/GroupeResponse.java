package com.example.hps.response;

import java.util.List;

import lombok.Data;

@Data
public class GroupeResponse {
	private Long idgroup;
	private String nomgroupe;
	private List<Sous_GroupeResponse> sous_Groupes;
	private List<UtilisateurResponse> utilisateurs;
}
