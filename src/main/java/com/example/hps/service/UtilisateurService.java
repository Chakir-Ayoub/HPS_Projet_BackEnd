package com.example.hps.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.hps.dto.AbsenceDto;
import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Utilisateur;

public interface UtilisateurService extends UserDetailsService {
	UtilisateurDto AjouterUtilisateur(UtilisateurDto utilisateurDto);
	UtilisateurDto ModifierUtilisateur(UtilisateurDto utilisateurDto,Long id,String email);
	void SupperimerUtilisateur(Long id,String email);
	List<UtilisateurDto> GetAllUser(String email);
	UtilisateurDto GetById(Long id);
	UtilisateurDto AjouterAbsenceToUtilisateur(Long iduser,AbsenceDto absenceDto );
	UtilisateurDto SupperimerAbsenceToUtilisateur(Long iduser,Long idabsence );
	Long NombreAbsenceNonJustifier(Long id);
	Long NombreAbsenceJustifier(Long id);
	Long GetCountUser();
	Long GetCountAbsence();
	List<UtilisateurDto> GetUserWhereGroupeNull();
	List<UtilisateurDto> GetUser_Group(Long id);
	UtilisateurDto AjouterSessionToUtilisateur(long iduser,Long idsession);
	UtilisateurDto SupperimerSessionToUser(long iduser,long idsession);
	UtilisateurDto GetUserBySession(Long idsession);
	UtilisateurDto getUser(String email);
	List<UtilisateurDto> getusersbyrole(String email);
	List<Utilisateur> GetIdUsers();
	List<String> GetnameUsers();
}
