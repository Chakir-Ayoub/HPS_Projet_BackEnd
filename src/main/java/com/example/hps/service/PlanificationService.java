package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.PlanificationDto;

public interface PlanificationService {
	PlanificationDto AjouterPlanification(PlanificationDto planificationDto);
	PlanificationDto ModifierPlanification(PlanificationDto planificationDto,Long id);
	void SupperimerPlanification(Long id);
	List<PlanificationDto> GetAllPlaning();
	PlanificationDto AffecteSessionToplanification(Long idsession,Long idplanification);
	PlanificationDto SupperimerSessionToPlanification(Long idsession,Long idplanification);
}
