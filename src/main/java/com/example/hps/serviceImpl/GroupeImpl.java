package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.GroupeDto;
import com.example.hps.dto.Sous_GroupeDto;
import com.example.hps.entity.Groupe;
import com.example.hps.repository.GroupeRepository;
import com.example.hps.service.GroupeService;


@Service
public class GroupeImpl implements GroupeService {

	@Autowired
	GroupeRepository groupeRepository;
	
	@Override
	public GroupeDto AjouterGroupe(GroupeDto groupeDto) {
		// TODO Auto-generated method stub
		
		Groupe groupecheck=groupeRepository.findBynomgroupe(groupeDto.getNomgroupe());
		if(groupecheck!=null) throw new RestException("Ce groupe il existe déja");
		
		for(int i=0;i<groupeDto.getSous_Groupes().size();i++) {
			Sous_GroupeDto sous_GroupeDto=groupeDto.getSous_Groupes().get(i);
			sous_GroupeDto.setGroupe(groupeDto);
			groupeDto.getSous_Groupes().set(i, sous_GroupeDto);
		}
		ModelMapper modelMapper=new ModelMapper();
		Groupe groupe=modelMapper.map(groupeDto, Groupe.class);
		
		Groupe  groupe2=groupeRepository.save(groupe);
		GroupeDto groupeDto2=modelMapper.map(groupe2, GroupeDto.class);
		
		
		return groupeDto2;
	}

	@Override
	public GroupeDto ModifierGroupe(GroupeDto groupeDto,Long id) {
		// TODO Auto-generated method stub
		Groupe groupecheck=groupeRepository.findByidgroup(id);
		if(groupecheck==null) throw new RestException("Ce groupe n'existe pas ");
		
		groupecheck.setNomgroupe(groupeDto.getNomgroupe());
		
		
		ModelMapper modelMapper=new ModelMapper();
		Groupe groupe=groupeRepository.save(groupecheck);
		GroupeDto groupeDto2=modelMapper.map(groupe, GroupeDto.class);
		
		
				
		return groupeDto2;
	}

	@Override
	public void SupperimerGroupe(Long id) {
		// TODO Auto-generated method stub
		Groupe groupe=groupeRepository.findByidgroup(id);
		if(groupe==null) throw new RestException("Ce groupe n'existe pas ");
		
		groupeRepository.delete(groupe);

	}

	@Override
	public List<GroupeDto> GetAllGroupe() {
		// TODO Auto-generated method stub
		List<Groupe> groupes;
		groupes = groupeRepository.findAll();
		
		List<GroupeDto> groupeDtos=new ArrayList<>();
		for(Groupe groupe: groupes) {
			ModelMapper modelMapper=new ModelMapper();
			GroupeDto groupeDto=modelMapper.map(groupe, GroupeDto.class);
			
			groupeDtos.add(groupeDto);
		}
		
		return groupeDtos;
	}

}
