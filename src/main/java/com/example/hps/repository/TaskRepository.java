package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hps.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	Task findByidtask(Long id);
	Task findByname(String nom);
	@Query(value = "SELECT * FROM `task` t WHERE t.columnn is null",nativeQuery = true)
	List<Task> GetTaskNull();
	@Query(value = "SELECT t.* FROM columnn c INNER JOIN task t on(c.idcolumn=t.columnn) WHERE c.idcolumn= :idcolumn ",nativeQuery = true)
	List<Task> GetTaskBySession(@Param("idcolumn") Long idcolumn);
	@Query(value = "SELECT t.* FROM columnn c INNER JOIN task t on(c.idcolumn=t.columnn) WHERE c.idcolumn= :idcolumn",nativeQuery = true)
	List<Task> GetTaskByColumn(@Param("idcolumn") Long idcolumn);
	@Query(value = "SELECT t.* from task t INNER JOIN columnn c on(t.columnn=c.idcolumn) INNER JOIN board b on(c.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) where u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Task> GetTaskByUser(@Param("idutilisateur") Long idutilisateur);
	
	@Query(value = "SELECT count(c.idcolumn) FROM session s INNER JOIN board b on(s.board_idboard=b.idboard) INNER JOIN columnn c on(b.idboard=c.board) INNER JOIN task t on(c.idcolumn=t.columnn) WHERE c.idcolumn= :idcolumn AND s.utilisateur= :utilisateur ",nativeQuery = true)
	Long GetCountTaskByUser(@Param("idcolumn") Long idcolumn,@Param("utilisateur") Long utilisateur);
}
