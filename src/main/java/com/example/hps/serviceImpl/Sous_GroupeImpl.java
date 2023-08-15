package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.Sous_GroupeDto;
import com.example.hps.entity.Sous_Groupe;
import com.example.hps.repository.Sous_GroupeRepository;
import com.example.hps.service.Sous_GroupeService;

@Service
public class Sous_GroupeImpl implements Sous_GroupeService {
	
	@Autowired
	Sous_GroupeRepository sous_GroupeRepository;
	@Override
	public Sous_GroupeDto AjouterSous_Groupe(Sous_GroupeDto sous_GroupeDto) {
		// TODO Auto-generated method stub
		Sous_Groupe sous_Groupecheck=sous_GroupeRepository.findBynomsousgroupe(sous_GroupeDto.getNomsousgroupe());
		if(sous_Groupecheck!=null) throw new RestException("Ce sous_groupe existe déja ");
		
		ModelMapper modelMapper=new ModelMapper();
		Sous_Groupe sous_Groupe=modelMapper.map(sous_GroupeDto, Sous_Groupe.class);
		
		Sous_Groupe sous_Groupe2=sous_GroupeRepository.save(sous_Groupe);
		Sous_GroupeDto groupeDTO=modelMapper.map(sous_Groupe2, Sous_GroupeDto.class);
		
		return groupeDTO;
	}

	@Override
	public Sous_GroupeDto ModifierSous_Groupe(Sous_GroupeDto sous_GroupeDto,Long id) {
		// TODO Auto-generated method stub
		Sous_Groupe sous_groupecheck=sous_GroupeRepository.findByidsousgroupe(id);
		if(sous_groupecheck==null) throw new RestException("Ce sous_groupe n'existe pas");
		else if(sous_GroupeRepository.findBynomsousgroupe(sous_GroupeDto.getNomsousgroupe())!=null) throw new RestException("Ce sous_groupe existe déja");
		
		
		sous_groupecheck.setNomsousgroupe(sous_GroupeDto.getNomsousgroupe());
		
		Sous_Groupe sous_GroupeModifier=sous_GroupeRepository.save(sous_groupecheck);
		
		ModelMapper modelMapper=new ModelMapper();
		
		Sous_GroupeDto sous_GroupeDto2=modelMapper.map(sous_GroupeModifier, Sous_GroupeDto.class);
	
		return sous_GroupeDto2;
	}

	@Override
	public void SupperimerSous_Groupe(Long id) {
		// TODO Auto-generated method stub
		
		Sous_Groupe sous_Groupe=sous_GroupeRepository.findByidsousgroupe(id);
		if(sous_Groupe==null) throw new RestException("Ce sous_groupe n'existe pas");
		
		sous_GroupeRepository.delete(sous_Groupe);

	}

	@Override
	public List<Sous_GroupeDto> GetAllSous_Groupe() {
		// TODO Auto-generated method stub
		List<Sous_Groupe> groupes;
		groupes=sous_GroupeRepository.findAll();
		
		List<Sous_GroupeDto> groupeDtos=new ArrayList<>();
		for(Sous_Groupe sous_Groupe: groupes) {
			ModelMapper modelMapper=new ModelMapper();
			Sous_GroupeDto sous_GroupeDto =modelMapper.map(sous_Groupe, Sous_GroupeDto.class);
			
			groupeDtos.add(sous_GroupeDto);
		}
		return groupeDtos;
	}

}
