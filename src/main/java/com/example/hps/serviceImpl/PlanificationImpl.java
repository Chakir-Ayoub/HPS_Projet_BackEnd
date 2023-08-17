package com.example.hps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.PlanificationDto;
import com.example.hps.dto.SessionDto;
import com.example.hps.entity.Planification;
import com.example.hps.entity.Session;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.PlanificationRepository;
import com.example.hps.repository.SessionRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.PlanificationService;

@Service
public class PlanificationImpl implements PlanificationService {
	
	@Autowired
	PlanificationRepository planificationRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public PlanificationDto AjouterPlanification(PlanificationDto planificationDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Planification planificationCheck=planificationRepository.findBydatePlanification(planificationDto.getDatePlanification());
		
		if(planificationCheck!=null) {


			PlanificationDto planificationDto2=new PlanificationDto();
			for(int i=0;i<planificationDto.getSessions().size();i++) {
				planificationDto2= AffecteSessionToplanification(planificationDto.getSessions().get(i), planificationCheck.getDatePlanification(),currentuser.getEmail());
			}
			return planificationDto2;
		}		
		
		for(int i=0;i<planificationDto.getSessions().size();i++) {
			SessionDto sessionDto=planificationDto.getSessions().get(i);
			sessionDto.setPlanification(planificationDto);
			planificationDto.getSessions().set(i, sessionDto);
		}
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planification=modelMapper.map(planificationDto, Planification.class);
		
		Planification newplanification=planificationRepository.save(planification);
		
		PlanificationDto planificationDto2=modelMapper.map(newplanification, PlanificationDto.class);
		
		return planificationDto2;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public PlanificationDto ModifierPlanification(PlanificationDto planificationDto,LocalDate date,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Planification planificationCheck=planificationRepository.findBydatePlanification(date);
		if(planificationCheck==null) throw new RestException("Cette planification n'existe pas ! ");
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planficationconvertToEntity=modelMapper.map(planificationDto, Planification.class);
		
		planificationCheck.setDatePlanification(planficationconvertToEntity.getDatePlanification());
		planificationCheck.setSessions(planficationconvertToEntity.getSessions());
		
	   planificationRepository.save(planificationCheck);
	 
	    PlanificationDto planificationDtoModifier = modelMapper.map(planificationCheck, PlanificationDto.class);
		return planificationDtoModifier;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void SupperimerPlanification(LocalDate date,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Planification planification=planificationRepository.findBydatePlanification(date);
		if(planification==null) throw new RestException("Cette Planification n'existe pas ! ");
		planificationRepository.delete(planification);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public List<PlanificationDto> GetAllPlaning(String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Planification> planifications=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		planifications=planificationRepository.findAll();
		}
		else {
			planifications=planificationRepository.GetPlanificationbyuser(currentuser.getIdutilisateur());
		}
		
		List<PlanificationDto> planificationDtos=new ArrayList<>();
		for(Planification planification: planifications) {
			ModelMapper modelMapper=new ModelMapper();
			PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);
			
			planificationDtos.add(planificationDto);
		}
		return planificationDtos;
		}

	@Override
	public PlanificationDto AffecteSessionToplanification(SessionDto session, LocalDate Date,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		ModelMapper modelMapper=new ModelMapper();
	//	Session session=sessionRepository.findByidsession(idsession);
		Planification planification=planificationRepository.findBydatePlanification(Date);

		Session session2=modelMapper.map(session, Session.class);
		planification.AjouterSession(session2, planification);
		planificationRepository.save(planification);
		
		PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);
		
		return planificationDto;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public PlanificationDto SupperimerSessionToPlanification(Long idsession, Long idplanification,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==8 ) {
		ModelMapper modelMapper=new ModelMapper();
		
		Session session=sessionRepository.findByidsession(idsession);
		Planification planification=planificationRepository.findByidPlanification(idplanification);
		
		planification.SupperimerSession(session);
		planificationRepository.save(planification);

		
		PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);

		return planificationDto;
		}else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}
	
	
	
}
