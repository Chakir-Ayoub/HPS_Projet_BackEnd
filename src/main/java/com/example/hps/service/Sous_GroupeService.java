package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.Sous_GroupeDto;

public interface Sous_GroupeService {
	Sous_GroupeDto AjouterSous_Groupe(Sous_GroupeDto sous_GroupeDto);
	Sous_GroupeDto ModifierSous_Groupe(Sous_GroupeDto sous_GroupeDto,Long id);
	void SupperimerSous_Groupe(Long id);
	List<Sous_GroupeDto> GetAllSous_Groupe();
}
