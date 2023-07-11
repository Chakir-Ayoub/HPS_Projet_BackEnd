package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Sous_Groupe;

public interface Sous_GroupeRepository extends JpaRepository<Sous_Groupe, Long> {
	Sous_Groupe findBynomsousgroupe(String nom);
	Sous_Groupe findByidsousgroupe(Long id);
}
