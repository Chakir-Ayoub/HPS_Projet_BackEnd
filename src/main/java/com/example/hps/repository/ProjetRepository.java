package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hps.entity.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	Projet findBynomprojet(String nom);
	Projet findByidprojet(Long id);
	@Query(value = "SELECT  COUNT(*) FROM `projet` ",nativeQuery = true)
	Long GetCountProject();
	@Query(value = "SELECT COUNT(*) FROM `projet` p WHERE p.datedemarrage=CURRENT_DATE",nativeQuery = true)
	Long GetStartProject();
}
