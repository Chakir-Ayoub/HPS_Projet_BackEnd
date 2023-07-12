package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.AbsenceDto;
import com.example.hps.entity.Absence;
import com.example.hps.entity.Utilisateur;

public interface AbsenceService {
	AbsenceDto AjouterAbsence(AbsenceDto absenceDto);
	AbsenceDto ModifierAbsence(AbsenceDto absenceDto,Long id);
	void SupperimerAbsence(Long id);
	List<AbsenceDto> GetAll();
}
