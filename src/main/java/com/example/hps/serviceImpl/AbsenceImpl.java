package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.AbsenceDto;
import com.example.hps.entity.Absence;
import com.example.hps.repository.AbsenceRepository;
import com.example.hps.service.AbsenceService;

@Service
public class AbsenceImpl implements AbsenceService {
	
	@Autowired
	AbsenceRepository absenceRepository;
	@Override
	public AbsenceDto AjouterAbsence(AbsenceDto absenceDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Absence absence=modelMapper.map(absenceDto, Absence.class);
		
		Absence absenceAjoute=absenceRepository.save(absence);
		AbsenceDto absenceDto2=modelMapper.map(absenceAjoute,AbsenceDto.class);
		
		return absenceDto2;
	}

	@Override
	public AbsenceDto ModifierAbsence(AbsenceDto absenceDto,Long id) {
		// TODO Auto-generated method stub
		Absence absencecheck=absenceRepository.findByidAbsence(id);
		if(absencecheck==null) throw new RestException("Ce Absence n'existe pas ! ");
		
		absencecheck.setDate_debut(absenceDto.getDate_debut());
		absencecheck.setDate_fin(absenceDto.getDate_fin());
		absencecheck.setType(absenceDto.getType());
		
		ModelMapper modelMapper=new ModelMapper();
		
		AbsenceDto absenceDto2=modelMapper.map(absencecheck, AbsenceDto.class);
		
		return absenceDto2;
	}

	@Override
	public void SupperimerAbsence(Long id) {
		// TODO Auto-generated method stub
		Absence absencecheck=absenceRepository.findByidAbsence(id);
		if(absencecheck==null) throw new RestException("Ce Absence n'existe pas ! ");
		
		absenceRepository.delete(absencecheck);
		}

	@Override
	public List<AbsenceDto> GetAll() {
		// TODO Auto-generated method stub
		List<Absence> absences;
		absences=absenceRepository.findAll();
		
		List<AbsenceDto> absenceDtos=new ArrayList<>();
		for(Absence absence: absences) {
			ModelMapper modelMapper=new ModelMapper();
			AbsenceDto absenceDto=modelMapper.map(absence, AbsenceDto.class);
			
			absenceDtos.add(absenceDto);
		}
		return absenceDtos;
	}

}
