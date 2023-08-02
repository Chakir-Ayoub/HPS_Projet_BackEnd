package com.example.hps.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Planification;

public interface PlanificationRepository extends JpaRepository<Planification, Long> {
	
	Planification findBydatePlanification(LocalDate date);
	Planification findByidPlanification(Long id);
}
