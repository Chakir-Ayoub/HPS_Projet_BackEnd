package com.example.hps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hps.dto.AbsenceDto;
import com.example.hps.repository.AbsenceRepository;
import com.example.hps.service.AbsenceService;

public class AbsenceImpl implements AbsenceService {
	
	@Autowired
	AbsenceRepository absenceRepository;
	@Override
	public AbsenceDto AjouterAbsence(AbsenceDto absenceDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbsenceDto ModifierAbsence(AbsenceDto absenceDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupperimerAbsence(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AbsenceDto> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
