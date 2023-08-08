package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Columnn;

public interface ColumnnRepository extends JpaRepository<Columnn, Long> {

	Columnn findByidcolumn(Long id);
}
