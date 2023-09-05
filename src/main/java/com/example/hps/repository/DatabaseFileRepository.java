package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {
	DatabaseFile findByid(String id);
	@Query(value = "SELECT f.* FROM files f INNER JOIN projet p on(f.project_idprojet=p.idprojet) WHERE p.idprojet= :idprojet ",nativeQuery = true)
	List<DatabaseFile> GetPinByProject(@Param("idprojet") Long idprojet);
	
	@Query(value = "SELECT * FROM files f WHERE f.type=true",nativeQuery = true)
	List<DatabaseFile> GetAll();
	
	@Query(value = "SELECT * FROM files f WHERE f.file_name= :name ",nativeQuery = true)
	DatabaseFile getdatafilebyname(@Param("name") String name);
	
/*	@Query(value = "SELECT * FROM files WHERE file_name LIKE '+%' OR file_name LIKE '%+%' OR file_name LIKE '%+'", nativeQuery = true)
	List<DatabaseFile> Getlikename(@Param("file_name") String name);*/

}