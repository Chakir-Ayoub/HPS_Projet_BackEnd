package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.UtilisateurDto;

public interface UtilisateurService {
	UtilisateurDto AjouterUtilisateur(UtilisateurDto utilisateurDto);
	UtilisateurDto ModifierUtilisateur(UtilisateurDto utilisateurDto,Long id);
	void SupperimerUtilisateur(Long id);
	List<UtilisateurDto> GetAllUser();
	UtilisateurDto GetById(Long id);
	UtilisateurDto AjouterAbsenceToUtilisateur(Long iduser,Long idabsence );
	UtilisateurDto SupperimerAbsenceToUtilisateur(Long iduser,Long idabsence );
	Long NombreAbsenceNonJustifier(Long id);
	Long NombreAbsenceJustifier(Long id);
	Long GetCountUser();
	Long GetCountAbsence();
}
