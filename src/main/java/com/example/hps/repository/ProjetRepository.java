package com.example.hps.repository;


import java.util.List;

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
	
	@Query(value = "SELECT p.* from  projet p inner join  board b on(p.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) where s.idsession=?1; ", nativeQuery = true)
	Projet GetProjectBySession(@Param("idsession") Long idsession);
	
	@Query(value = "DELETE FROM projet WHERE datedemarrage < DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY); ",nativeQuery = true)
	Long DropProjectByDate();
	
	@Query(value = "SELECT p.*FROM projet p INNER JOIN board b on(p.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Projet> GetProjectByUser(@Param("idutilisateur") Long idutilisateur);
}
