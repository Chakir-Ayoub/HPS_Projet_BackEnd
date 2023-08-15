package com.example.hps.service;

import java.time.LocalDate;
import java.util.List;

import com.example.hps.dto.PlanificationDto;
import com.example.hps.dto.SessionDto;

public interface PlanificationService {
	PlanificationDto AjouterPlanification(PlanificationDto planificationDto);
	PlanificationDto ModifierPlanification(PlanificationDto planificationDto,LocalDate date);
	void SupperimerPlanification(LocalDate date);
	List<PlanificationDto> GetAllPlaning();
	PlanificationDto AffecteSessionToplanification(SessionDto session,LocalDate Date);
	PlanificationDto SupperimerSessionToPlanification(Long idsession,Long idplanification);
}
