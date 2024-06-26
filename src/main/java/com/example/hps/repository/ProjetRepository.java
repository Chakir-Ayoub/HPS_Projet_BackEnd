package com.example.hps.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.hps.entity.Projet;
import com.example.hps.response.ResponseChart;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	Projet findBynomprojet(String nom);
	Projet findByidprojet(long id);
	
	@Query(value = "SELECT  COUNT(*) FROM `projet` ",nativeQuery = true)
	Long GetCountProject();
	
	@Query(value = "SELECT COUNT(*) FROM `projet` p WHERE p.datedemarrage=CURRENT_DATE",nativeQuery = true)
	Long GetStartProject();
	
	@Query(value = "SELECT p.* from  projet p inner join  board b on(p.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) where s.idsession= :idsession ", nativeQuery = true)
	Projet GetProjectBySession(@Param("idsession") Long idsession);
	
	@Query(value = "DELETE FROM projet WHERE datedemarrage < DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY); ",nativeQuery = true)
	Long DropProjectByDate();
	
	@Query(value = "SELECT p.*FROM projet p INNER JOIN board b on(p.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Projet> GetProjectByUser(@Param("idutilisateur") Long idutilisateur);
	
	@Query(value = "SELECT p.nomprojet FROM projet p ",nativeQuery = true)
	List<String> GetAllProjectName();
	
	@Query(value = "SELECT c.name as 'Count' from board b INNER JOIN columnn c on(b.idboard=c.board) INNER JOIN task t on(c.idcolumn=t.columnn) WHERE b.name= :name GROUP BY c.name",nativeQuery = true)
	List<String> GetNameColumnCount(@Param("name") String name);
	
	@Query(value = "SELECT COUNT(t.idtask) as 'Count' from board b INNER JOIN columnn c on(b.idboard=c.board) INNER JOIN task t on(c.idcolumn=t.columnn) WHERE c.name='Todo' GROUP BY b.name; ",nativeQuery = true)
	List<Long> GetCountTodo();
	
	@Query(value = "SELECT COUNT(t.idtask) as 'Count' from board b INNER JOIN columnn c on(b.idboard=c.board) INNER JOIN task t on(c.idcolumn=t.columnn) WHERE c.name='Done' GROUP BY b.name;",nativeQuery = true)
	List<Long> GetCountDone( );
}
