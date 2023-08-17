package com.example.hps.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoleDto {
	private Long idRole;
	private String nom;
	private List<UtilisateurDto> utilisateurs;
}
