package com.example.hps.serviceImpl;

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
		
		ModelMapper modelMapper=new ModelMapper();
		Planification planification=modelMapper.map(planificationDto, Planification.class);
		
		
		for(int i=0;i<planificationDto.getSessions().size();i++) {
			SessionDto sessionDto=planificationDto.getSessions().get(i);
			sessionDto.setPlanification(planificationDto);
			planificationDto.getSessions().set(i, sessionDto);
		}
		
		Planification newplanification=planificationRepository.save(planification);
		
		PlanificationDto planificationDto2=modelMapper.map(newplanification, PlanificationDto.class);
		
		return planificationDto2;
	}

	@Override
	public PlanificationDto ModifierPlanification(PlanificationDto planificationDto) {
		// TODO Auto-generated method stub
				
		return null;
	}

	@Override
	public void SupperimerPlanification(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlanificationDto> GetAllPlaning() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
