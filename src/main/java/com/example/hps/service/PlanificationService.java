package com.example.hps.service;

import java.time.LocalDate;
import java.util.List;

import com.example.hps.dto.PlanificationDto;
import com.example.hps.dto.SessionDto;

public interface PlanificationService {
	PlanificationDto AjouterPlanification(PlanificationDto planificationDto,String email);
	PlanificationDto ModifierPlanification(PlanificationDto planificationDto,LocalDate date,String email);
	void SupperimerPlanification(LocalDate date,String email);
	List<PlanificationDto> GetAllPlaning(String email);
	PlanificationDto AffecteSessionToplanification(SessionDto session,LocalDate Date,String email);
	PlanificationDto SupperimerSessionToPlanification(Long idsession,Long idplanification,String email);
}
