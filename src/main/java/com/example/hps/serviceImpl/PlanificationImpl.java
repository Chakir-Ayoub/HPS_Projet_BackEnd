package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.dto.PlanificationDto;
import com.example.hps.dto.SessionDto;
import com.example.hps.entity.Planification;
import com.example.hps.repository.PlanificationRepository;
import com.example.hps.service.PlanificationService;

@Service
public class PlanificationImpl implements PlanificationService {
	
	@Autowired
	PlanificationRepository planificationRepository;

	@Override
	public PlanificationDto AjouterPlanification(PlanificationDto planificationDto) {
		// TODO Auto-generated method stub
		Planification planificationCheck=planificationRepository.findBydatePlanification(planificationDto.getDatePlanification());
		if(planificationCheck!=null) throw new RuntimeException("Cette planification il existe déja ! ");
		

		
		
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
		if(planificationCheck==null) throw new RuntimeException("Cette planification n'existe pas ! ");
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planficationconvertToEntity=modelMapper.map(planificationDto, Planification.class);
		
		planificationCheck.setDatePlanification(planficationconvertToEntity.getDatePlanification());
		planificationCheck.setSessions(planficationconvertToEntity.getSessions());
		
	   planificationRepository.save(planificationCheck);
	 
	    PlanificationDto planificationDtoModifier = modelMapper.map(planificationCheck, PlanificationDto.class);
		return planificationDtoModifier;
	}

	@Override
	public void SupperimerPlanification(Long id) {
		// TODO Auto-generated method stub
		Planification planification=planificationRepository.findByidPlanification(id);
		if(planification==null) throw new RuntimeException("Cette Planification n'existe oas ! ");
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
	
}
