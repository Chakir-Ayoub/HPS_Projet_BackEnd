package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.GroupeDto;

public interface GroupeService {
	GroupeDto AjouterGroupe(GroupeDto groupeDto);
	GroupeDto ModifierGroupe(GroupeDto groupeDto, Long id);
	void SupperimerGroupe(Long id);
	List<GroupeDto> GetAllGroupe();
}
