package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.SessionDto;
import com.example.hps.entity.Session;
import com.example.hps.repository.SessionRepository;
import com.example.hps.service.SessionService;

@Service
public class SessionImpl implements SessionService {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Override
	public SessionDto AjouterSession(SessionDto sessionDto) {
		// TODO Auto-generated method stub
		Session sessioncheck=sessionRepository.findBynomsession(sessionDto.getNomsession());
		if(sessioncheck!=null) throw new RestException("Cette Session il existe déja !");
		
		ModelMapper modelMapper =new ModelMapper();
		Session session=modelMapper.map(sessionDto, Session.class);
		
		Session newSession=sessionRepository.save(session);
		
		SessionDto sessionDtoAjouter=modelMapper.map(newSession, SessionDto.class);
		
		return sessionDtoAjouter;
	}

	@Override
	public SessionDto ModifierSession(SessionDto sessionDto,Long id) {
		// TODO Auto-generated method stub
		Session sessionCheck=sessionRepository.findByidsession(id);
		if(sessionCheck==null) throw new RestException("Cette Session il n'existe pas !");

		ModelMapper modelMapper=new ModelMapper();
		Session modifierObjectSession=modelMapper.map(sessionDto, Session.class);
		
		sessionCheck.setHeureD(sessionDto.getHeureD());
		sessionCheck.setHeureF(sessionDto.getHeureF());
		if(sessionRepository.findBynomsession(sessionDto.getNomsession())==null) {
			sessionCheck.setNomsession(sessionDto.getNomsession());
		}
		else { 
			 throw new RuntimeException("Ce Nom de Projet Il existe Déja ");
		}
			
		Session ObjetModifier=sessionRepository.save(sessionCheck);
		
		SessionDto sessionDto2=modelMapper.map(ObjetModifier, SessionDto.class);
		return sessionDto2;
	}

	@Override
	public void SupperimerSession(Long id) {
		// TODO Auto-generated method stub
		Session sessionCheck=sessionRepository.findByidsession(id);
		if(sessionCheck==null) throw new RestException("Cette Session il n'existe pas ! ");
		
		sessionRepository.delete(sessionCheck);
	}

	@Override
	public List<SessionDto> GetAllSession() {
		// TODO Auto-generated method stub
		List<Session> sessions;
		sessions=sessionRepository.findAll();
		
		List<SessionDto> sessionDtos=new ArrayList<>();
		for(Session session: sessions) {
			
			ModelMapper modelMapper=new ModelMapper();
			SessionDto sessionDto=modelMapper.map(session, SessionDto.class);
			
			sessionDtos.add(sessionDto);
		}
		
		
		return sessionDtos;
	}

}
