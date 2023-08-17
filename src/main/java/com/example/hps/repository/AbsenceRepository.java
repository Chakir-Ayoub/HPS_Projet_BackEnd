package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hps.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
	Absence findByidAbsence(Long id);
	
	@Query(value = "SELECT COUNT(*) FROM `absence` a WHERE  a.utilisateur_id=?1 and a.type=1",nativeQuery = true)
	Long AbsenceNonJustifier(Long utilisateur_id);
	
	@Query(value = "SELECT COUNT(*) FROM `absence` a WHERE  a.utilisateur_id=?1 and a.type=0",nativeQuery = true)
	Long AbsenceJustifier(Long utilisateur_id);
	
	@Query(value = "SELECT count(*) FROM `absence` a WHERE a.type=1 and a.date_debut=CURRENT_DATE ",nativeQuery = true)
	Long GetCountAbsence();
	
	@Query(value = "SELECT a.* FROM absence a WHERE a.utilisateur_id= :utilisateur_id",nativeQuery = true)
	List<Absence> findByIdUser(Long utilisateur_id);
}
