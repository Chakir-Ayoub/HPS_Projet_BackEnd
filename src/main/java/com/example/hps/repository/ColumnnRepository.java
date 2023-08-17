package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Columnn;

public interface ColumnnRepository extends JpaRepository<Columnn, Long> {
	Columnn findByidcolumn(Long id);
	
	@Query(value = "SELECT c.* from projet p INNER JOIN board b on(b.idboard=p.board) INNER JOIN columnn c on(b.idboard=c.board) where p.idprojet= :idprojet ",nativeQuery = true)
	List<Columnn> GetColumnByIdproject(@Param("idprojet") Long idprojet);
	
	@Query(value = "SELECT COUNT(*) FROM projet p INNER JOIN board b ON (b.idboard = p.board) INNER JOIN columnn c ON (b.idboard = c.board) INNER JOIN task t ON (c.idcolumn = t.columnn) WHERE p.idprojet = :idprojet AND c.name = :name ",nativeQuery = true)
	Long getcounttask( @Param("idprojet")  Long idprojet,@Param("name") String name);
	
	@Query(value = "SELECT c.* from columnn c INNER JOIN board b on(c.board=b.idboard) INNER JOIN session s on(b.idboard=s.board_idboard) INNER JOIN utilisateur u on(s.utilisateur=u.idutilisateur) WHERE u.idutilisateur= :idutilisateur",nativeQuery = true)
	List<Columnn> getColumnByUser(@Param("idutilisateur") Long idutilisateur);
}
