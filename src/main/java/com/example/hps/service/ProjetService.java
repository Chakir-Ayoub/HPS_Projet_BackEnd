package com.example.hps.service;

import java.util.List;


import com.example.hps.dto.ProjetDto;

public interface ProjetService {
	ProjetDto AjouterProjet(ProjetDto projetDto);
    ProjetDto ModifierProjet(ProjetDto projetDto,Long id);
	void SupperimerProjet(Long id);
	List<ProjetDto> GetAllProjet();
	ProjetDto AjouterDetailToProjet(Long iddetail,Long idprojet);
	ProjetDto SupperimerDetailToProjet(Long iddetail,Long idprojet);
	ProjetDto GetById(Long id);
	Long GetCountProject();
	Long GetProjectStar();
	ProjetDto GetProjectBysesssion(Long idsession);
	void DropProjectByDate();
}
