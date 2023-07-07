package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	Session findBynomsession(String nom);
	Session findByidsession(Long id);
}
