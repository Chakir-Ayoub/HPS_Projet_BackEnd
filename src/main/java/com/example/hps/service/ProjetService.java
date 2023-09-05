package com.example.hps.service;

import java.util.List;


import com.example.hps.dto.ProjetDto;
import com.example.hps.entity.DatabaseFile;
import com.example.hps.entity.Projet;
import com.example.hps.response.ResponseChart;

public interface ProjetService {
	ProjetDto AjouterProjet(ProjetDto projetDto,String email);
    ProjetDto ModifierProjet(ProjetDto projetDto,Long id,String email);
	void SupperimerProjet(Long id,String email);
	List<ProjetDto> GetAllProjet(String email);
	ProjetDto GetById(Long id,String email);
	Long GetCountProject();
	Long GetProjectStar();
	ProjetDto GetProjectBysesssion(Long idsession,String email);
	void DropProjectByDate(String email);
	ProjetDto AddDetailToProject(DatabaseFile databaseFile,Long idprojet);
	List<ProjetDto> GetProjet();
	List<String> GetAllProjectName();
	List<String> GetProjectColumnCount(String name);
	List<Long> GetCountTodo();
	List<Long> GetCountDone();

}
