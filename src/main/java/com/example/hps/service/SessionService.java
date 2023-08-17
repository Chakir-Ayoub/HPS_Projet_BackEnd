package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.SessionDto;

public interface SessionService {
	SessionDto AjouterSession(SessionDto sessionDto,String email);
	SessionDto ModifierSession(SessionDto sessionDto,Long id,String email);
	void SupperimerSession(Long id,String email);
	List<SessionDto> GetAllSession(String email);
}
