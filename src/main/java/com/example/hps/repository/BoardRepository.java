package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByidboard(Long id);
	@Query(value = "SELECT b.* FROM board b INNER JOIN session s on(b.idboard=s.board_idboard) WHERE s.idsession= :idsession",nativeQuery = true)
	Board boardbysession(@Param("idsession") Long idsession);
	@Query(value = "SELECT b.* FROM projet p INNER JOIN board b ON(p.board=b.idboard) WHERE p.idprojet= :idprojet ",nativeQuery = true)
	Board getboardbycolumn(@Param("idprojet") Long idprojet);
	@Query(value = "SELECT b.* FROM board b INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Board> getBoardByUser(@Param("idutilisateur") Long idutilisateur);
}
