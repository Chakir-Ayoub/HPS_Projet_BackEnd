package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Utilisateur findByemail(String email);
	Utilisateur findBytelephone(int telephone);
	Utilisateur findByidutilisateur(Long id);
	@Query(value = "SELECT COUNT(*) FROM `utilisateur`",nativeQuery = true)
	Long getCountUser();
	
	@Query(value = "SELECT * FROM `utilisateur` u  WHERE u.id_groupe IS null",nativeQuery = true)
	List<Utilisateur> GetUserwhereGroupeIsNull();
	
	@Query(value = "SELECT u.* FROM groupe g INNER JOIN utilisateur u ON(g.idgroup=u.id_groupe) WHERE g.idgroup=?1 ORDER BY `u`.`idutilisateur` ASC; ",nativeQuery = true)
	List<Utilisateur> GetUser_Group(Long idgroup);
	
	
	@Query(value ="SELECT u.* FROM Utilisateur u INNER JOIN session s ON(u.idutilisateur=s.utilisateur)  WHERE s.idsession=?1",nativeQuery = true)
	Utilisateur getUser_Session(Long idsession);
	
	@Query(value="SELECT * FROM utilisateur u INNER JOIN groupe g ON (u.id_groupe = g.idgroup) WHERE u.role = 3 AND g.idgroup IN (SELECT DISTINCT id_groupe FROM utilisateur WHERE role = :role ) LIMIT 0, 25;"
			,nativeQuery = true)
	List<Utilisateur> getAllUsersByGroupe(@Param("role") Long role);

	@Query(value = "SELECT * FROM utilisateur u WHERE u.role= :role",nativeQuery = true)
	List<Utilisateur> getUsersByRole(@Param("role") Long role);

	 
}
