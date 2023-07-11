package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Utilisateur findByemail(String email);
	Utilisateur findBytelephone(int telephone);
	Utilisateur findByidutilisateur(Long id);
}
