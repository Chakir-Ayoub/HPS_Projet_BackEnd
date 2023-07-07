package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.UtilisateurDto;

public interface UtilisateurService {
	UtilisateurDto AjouterUtilisateur(UtilisateurDto utilisateurDto);
	UtilisateurDto ModifierUtilisateur(UtilisateurDto utilisateurDto);
	void SupperimerUtilisateur(Long id);
	List<UtilisateurDto> GetAllUser();
}
