package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	Projet findBynomprojet(String nom);
	Projet findByidprojet(Long id);
}
