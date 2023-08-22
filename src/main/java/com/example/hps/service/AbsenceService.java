package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.AbsenceDto;

public interface AbsenceService {
	AbsenceDto AjouterAbsence(AbsenceDto absenceDto,String email);
	AbsenceDto ModifierAbsence(AbsenceDto absenceDto,Long id,String email);
	void SupperimerAbsence(Long id,String email);
	List<AbsenceDto> GetAll(String email);
	AbsenceDto GetById(Long id,String email);
}
