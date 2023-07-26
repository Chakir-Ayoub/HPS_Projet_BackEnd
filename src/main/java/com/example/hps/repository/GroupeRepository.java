package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hps.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
	Groupe findBynomgroupe(String nom);
	Groupe findByidgroup(Long id);
	@Query(value = "SELECT COUNT(*) from utilisateur u WHERE u.id_groupe=?1",nativeQuery = true)
	Long getCountUserInGroupe(Long id_groupe);
}
