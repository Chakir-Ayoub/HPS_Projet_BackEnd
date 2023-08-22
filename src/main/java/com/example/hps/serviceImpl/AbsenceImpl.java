package com.example.hps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.AbsenceDto;
import com.example.hps.entity.Absence;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.AbsenceRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.AbsenceService;

@Service
public class AbsenceImpl implements AbsenceService {
	
	@Autowired
	AbsenceRepository absenceRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public AbsenceDto AjouterAbsence(AbsenceDto absenceDto,String email) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Absence absence=modelMapper.map(absenceDto, Absence.class);
		
		LocalDate currentdate=LocalDate.now();
		
		if(currentdate.isAfter(absenceDto.getDate_debut())) {throw new RestException("La date de Debut n'est pas acceptée ");}
		if(currentdate.isAfter(absenceDto.getDate_fin())) {throw new RestException("La date de Fin n'est pas acceptée ");}
		if (currentdate.isEqual(absenceDto.getDate_fin())) { throw new RestException("La date de Fin  est la même que la date actuelle.");}
		Utilisateur utilisateurcheckemail=utilisateurRepository.findByemail(email);
		absence.setUtilisateur(utilisateurcheckemail);
		
		Absence absenceAjoute=absenceRepository.save(absence);
		AbsenceDto absenceDto2=modelMapper.map(absenceAjoute,AbsenceDto.class);
		
		return absenceDto2;
	}

	@Override
	public AbsenceDto ModifierAbsence(AbsenceDto absenceDto,Long id,String email) {
		// TODO Auto-generated method stub
		Absence absencecheck=absenceRepository.findByidAbsence(id);
		if(absencecheck==null) throw new RestException("Ce Absence n'existe pas ! ");
		

		LocalDate currentdate=LocalDate.now();
		
		if(currentdate.isAfter(absenceDto.getDate_debut())) {throw new RestException("La date de Debut n'est pas acceptée ");}
		if(currentdate.isAfter(absenceDto.getDate_fin())) {throw new RestException("La date de Fin n'est pas acceptée ");}
		if (currentdate.isEqual(absenceDto.getDate_fin())) { throw new RestException("La date de Fin  est la même que la date actuelle.");}
		
		ModelMapper modelMapper=new ModelMapper();
		
		absencecheck.setDate_debut(absenceDto.getDate_debut());
		absencecheck.setDate_fin(absenceDto.getDate_fin());
		absencecheck.setType(absenceDto.getType());
		
		absenceRepository.save(absencecheck);
		
		AbsenceDto absenceDto2=modelMapper.map(absencecheck, AbsenceDto.class);
		
		return absenceDto2;
	}

	@Override
	public void SupperimerAbsence(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1) {
			Absence absencecheck=absenceRepository.findByidAbsence(id);
		if(absencecheck==null) throw new RestException("Ce Absence n'existe pas ! ");
		
		absenceRepository.delete(absencecheck);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête ");
		}
			
		}

	@Override
	public List<AbsenceDto> GetAll(String email) {
		// TODO Auto-generated method stub
		
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Absence> absences=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==1) {
			absences=absenceRepository.findAll();
		}
		else if (currentuser.getRole().getIdRole()== 2) {
			absences=absenceRepository.findAll();
		}
		else if (currentuser.getRole().getIdRole()== 3) {
			absences=absenceRepository.findByIdUser(currentuser.getIdutilisateur());
		}
		List<AbsenceDto> absenceDtos=new ArrayList<>();
		for(Absence absence: absences) {
			ModelMapper modelMapper=new ModelMapper();
			AbsenceDto absenceDto=modelMapper.map(absence, AbsenceDto.class);
			absenceDtos.add(absenceDto);
		}
		return absenceDtos;
	}

	@Override
	public AbsenceDto GetById(Long id,String email) {
		
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		ModelMapper modelMapper=new ModelMapper();
		Absence absence=this.absenceRepository.findByidAbsence(id);
		if(absence==null) throw new RestException("Ce Absence N'existe pas ");
		AbsenceDto absenceDto=modelMapper.map(absence, AbsenceDto.class);
		return absenceDto;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}



}
