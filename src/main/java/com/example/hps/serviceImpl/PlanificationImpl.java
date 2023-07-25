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
import com.example.hps.repository.PlanificationRepository;
import com.example.hps.repository.SessionRepository;
import com.example.hps.service.PlanificationService;

@Service
public class PlanificationImpl implements PlanificationService {
	
	@Autowired
	PlanificationRepository planificationRepository;
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public PlanificationDto AjouterPlanification(PlanificationDto planificationDto) {
		// TODO Auto-generated method stub
		Planification planificationCheck=planificationRepository.findBydatePlanification(planificationDto.getDatePlanification());
		if(planificationCheck!=null) throw new RestException("Cette planification il existe déja ! ");
		
		
		for(int i=0;i<planificationDto.getSessions().size();i++) {
			SessionDto sessionDto=planificationDto.getSessions().get(i);
			sessionDto.setPlanification(planificationDto);
			planificationDto.getSessions().set(i, sessionDto);
		}
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planification=modelMapper.map(planificationDto, Planification.class);
		
		Planification newplanification=planificationRepository.save(planification);
		
		PlanificationDto planificationDto2=modelMapper.map(newplanification, PlanificationDto.class);
		
		return planificationDto2;
	}

	@Override
	public PlanificationDto ModifierPlanification(PlanificationDto planificationDto,Long id) {
		// TODO Auto-generated method stub
		Planification planificationCheck=planificationRepository.findByidPlanification(id);
		if(planificationCheck==null) throw new RestException("Cette planification n'existe pas ! ");
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planficationconvertToEntity=modelMapper.map(planificationDto, Planification.class);
		
		planificationCheck.setDatePlanification(planficationconvertToEntity.getDatePlanification());
		planificationCheck.setSessions(planficationconvertToEntity.getSessions());
		
	   planificationRepository.save(planificationCheck);
	 
	    PlanificationDto planificationDtoModifier = modelMapper.map(planificationCheck, PlanificationDto.class);
		return planificationDtoModifier;
	}

	@Override
	public void SupperimerPlanification(LocalDate date) {
		// TODO Auto-generated method stub
		Planification planification=planificationRepository.findBydatePlanification(date);
		if(planification==null) throw new RestException("Cette Planification n'existe pas ! ");
		planificationRepository.delete(planification);
	}

	@Override
	public List<PlanificationDto> GetAllPlaning() {
		// TODO Auto-generated method stub
		List<Planification> planifications;
		planifications=planificationRepository.findAll();
		
		List<PlanificationDto> planificationDtos=new ArrayList<>();
		for(Planification planification: planifications) {
			ModelMapper modelMapper=new ModelMapper();
			PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);
			
			planificationDtos.add(planificationDto);
		}
		return planificationDtos;
	}

	@Override
	public PlanificationDto AffecteSessionToplanification(Long idsession, Long idplanification) {
		// TODO Auto-generated method stub
		
		ModelMapper modelMapper=new ModelMapper();
		Session session=sessionRepository.findByidsession(idsession);
		Planification planification=planificationRepository.findByidPlanification(idplanification);
		
		planification.AjouterSession(session, planification);
		planificationRepository.save(planification);
		
		PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);
		
		return planificationDto;
	}

	@Override
	public PlanificationDto SupperimerSessionToPlanification(Long idsession, Long idplanification) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Session session=sessionRepository.findByidsession(idsession);
		Planification planification=planificationRepository.findByidPlanification(idplanification);
		
		planification.SupperimerSession(session);
		planificationRepository.save(planification);

		
		PlanificationDto planificationDto=modelMapper.map(planification, PlanificationDto.class);

		return planificationDto;
	}
	
	
	
}
