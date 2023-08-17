package com.example.hps.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Planification;

public interface PlanificationRepository extends JpaRepository<Planification, Long> {
	Planification findBydatePlanification(LocalDate date);
	Planification findByidPlanification(Long id);
	
	@Query(value = "SELECT p.* FROM planification p INNER JOIN session s on(p.id_planification=s.planification) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur ",nativeQuery = true)
	List<Planification> GetPlanificationbyuser(@Param("idutilisateur") Long idutilisateur);
}
