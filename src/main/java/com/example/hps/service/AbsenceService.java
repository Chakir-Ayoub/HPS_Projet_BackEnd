package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.AbsenceDto;

public interface AbsenceService {
	AbsenceDto AjouterAbsence(AbsenceDto absenceDto);
	AbsenceDto ModifierAbsence(AbsenceDto absenceDto);
	void SupperimerAbsence(Long id);
	List<AbsenceDto> GetAll();
}
