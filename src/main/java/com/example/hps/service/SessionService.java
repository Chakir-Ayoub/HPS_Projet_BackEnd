package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.SessionDto;

public interface SessionService {
	SessionDto AjouterSession(SessionDto sessionDto);
	SessionDto ModifierSession(SessionDto sessionDto,Long id);
	void SupperimerSession(Long id);
	List<SessionDto> GetAllSession();
}
