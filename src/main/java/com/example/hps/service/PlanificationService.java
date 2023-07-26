package com.example.hps.service;

import java.time.LocalDate;
import java.util.List;

import com.example.hps.dto.PlanificationDto;

public interface PlanificationService {
	PlanificationDto AjouterPlanification(PlanificationDto planificationDto);
	PlanificationDto ModifierPlanification(PlanificationDto planificationDto,LocalDate date);
	void SupperimerPlanification(LocalDate date);
	List<PlanificationDto> GetAllPlaning();
	PlanificationDto AffecteSessionToplanification(Long idsession,Long idplanification);
	PlanificationDto SupperimerSessionToPlanification(Long idsession,Long idplanification);
}
