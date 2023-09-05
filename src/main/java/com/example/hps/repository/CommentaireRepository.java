package com.example.hps.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	Commentaire findByid(long id);
	
	@Query(value = "Select c.* from session s inner join board b on(s.board_idboard=b.idboard) inner join projet p on(b.idboard=p.board) inner join commentaire c on(p.idprojet=c.projet_idprojet) where s.idsession= :idsession",nativeQuery = true)
	List<Commentaire> getAllCommentairebysession(@Param("idsession") Long idsession);
}
