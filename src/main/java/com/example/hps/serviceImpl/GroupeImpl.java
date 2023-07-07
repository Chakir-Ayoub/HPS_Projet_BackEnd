package com.example.hps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hps.dto.GroupeDto;
import com.example.hps.repository.GroupeRepository;
import com.example.hps.service.GroupeService;

public class GroupeImpl implements GroupeService {

	@Autowired
	GroupeRepository groupeRepository;
	
	@Override
	public GroupeDto AjouterGroupe(GroupeDto groupeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupeDto ModifierGroupe(GroupeDto groupeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupperimerGroupe(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GroupeDto> GetAllGroupe() {
		// TODO Auto-generated method stub
		return null;
	}

}
