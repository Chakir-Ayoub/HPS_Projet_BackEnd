package com.example.hps.service;

import java.util.List;


import com.example.hps.dto.ProjetDto;

public interface ProjetService {
	ProjetDto AjouterProjet(ProjetDto projetDto);
    ProjetDto ModifierProjet(ProjetDto projetDto,Long id);
	void SupperimerProjet(Long id);
	List<ProjetDto> GetAllProjet();
}