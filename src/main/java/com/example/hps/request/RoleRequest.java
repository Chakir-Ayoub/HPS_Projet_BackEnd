package com.example.hps.request;

import java.util.List;

import lombok.Data;

@Data
public class RoleRequest {
	private Long idRole;
	private String nom;
	private List<UtilisateurRequest> utilisateurs;
}
