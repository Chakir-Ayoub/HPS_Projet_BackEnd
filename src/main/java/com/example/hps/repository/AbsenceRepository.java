package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
	Absence findByidAbsence(Long id);
}
