package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
	Groupe findBynomgroupe(String nom);
	Groupe findByidgroup(Long id);
	@Query(value = "SELECT COUNT(*) from utilisateur u WHERE u.id_groupe=?1",nativeQuery = true)
	Long getCountUserInGroupe(Long id_groupe);
	@Query(value = "SELECT g.* FROM groupe g INNER JOIN utilisateur u on(g.idgroup=u.id_groupe) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Groupe> getgroupbyuser(@Param("idutilisateur") Long idutilisateur);
}
