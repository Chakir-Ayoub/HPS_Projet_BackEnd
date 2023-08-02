package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	Projet findBynomprojet(String nom);
	Projet findByidprojet(Long id);
	@Query(value = "SELECT  COUNT(*) FROM `projet` ",nativeQuery = true)
	Long GetCountProject();
	@Query(value = "SELECT COUNT(*) FROM `projet` p WHERE p.datedemarrage=CURRENT_DATE",nativeQuery = true)
	Long GetStartProject();
	
	
	@Query(value = "SELECT p.* FROM projet p INNER JOIN detail d ON (d.projet = p.idprojet) INNER JOIN session s ON (d.id_session = s.idsession) INNER JOIN utilisateur u ON (s.idsession = u.id_session) WHERE s.idsession = :idsession", nativeQuery = true)
	Projet GetProjectBySession(@Param("idsession") Long idsession);
	
	@Query(value = "DELETE FROM projet WHERE datedemarrage < DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY); ",nativeQuery = true)
	Long DropProjectByDate();

}
