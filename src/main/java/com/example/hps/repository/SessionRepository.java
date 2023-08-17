package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	Session findBynomsession(String nom);
	Session findByidsession(Long id);
	
	@Query(value = "SELECT * FROM session s INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Session> getsessionbyuser(@Param("idutilisateur") Long idutilisateur);
}
