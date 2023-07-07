package com.example.hps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hps.dto.Sous_GroupeDto;
import com.example.hps.repository.Sous_GroupeRepository;
import com.example.hps.service.Sous_GroupeService;

public class Sous_GroupeImpl implements Sous_GroupeService {
	
	@Autowired
	Sous_GroupeRepository sous_GroupeRepository;
	@Override
	public Sous_GroupeDto AjouterSous_Groupe(Sous_GroupeDto sous_GroupeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sous_GroupeDto ModifierSous_Groupe(Sous_GroupeDto sous_GroupeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupperimerSous_Groupe(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Sous_GroupeDto> GetAllSous_Groupe() {
		// TODO Auto-generated method stub
		return null;
	}

}
