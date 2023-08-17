package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.SessionDto;
import com.example.hps.entity.Session;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.SessionRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.SessionService;

@Service
public class SessionImpl implements SessionService {
	
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public SessionDto AjouterSession(SessionDto sessionDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Session sessioncheck=sessionRepository.findBynomsession(sessionDto.getNomsession());
		
		ModelMapper modelMapper =new ModelMapper();
		sessionDto.setUtilisateur(sessionDto.getUtilisateur());
		Session session=modelMapper.map(sessionDto, Session.class);
		
		
		
		Session newSession=sessionRepository.save(session);
		
		SessionDto sessionDtoAjouter=modelMapper.map(newSession, SessionDto.class);
		
		return sessionDtoAjouter;
		}else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public SessionDto ModifierSession(SessionDto sessionDto,Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Session sessionCheck=sessionRepository.findByidsession(id);
		if(sessionCheck==null) throw new RestException("Cette Session il n'existe pas !");

		ModelMapper modelMapper=new ModelMapper();
		
			sessionCheck.setNomsession(sessionDto.getNomsession());
			sessionCheck.setHeureD(sessionDto.getHeureD());
			sessionCheck.setHeureF(sessionDto.getHeureF());

			
		Session ObjetModifier=sessionRepository.save(sessionCheck);
		
		SessionDto sessionDto2=modelMapper.map(ObjetModifier, SessionDto.class);
		return sessionDto2;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void SupperimerSession(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 ) {
		Session sessionCheck=sessionRepository.findByidsession(id);
		if(sessionCheck==null) throw new RestException("Cette Session il n'existe pas ! ");
		
		sessionRepository.delete(sessionCheck);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public List<SessionDto> GetAllSession(String email) {
		// TODO Auto-generated method stub
		List<Session> sessions=new ArrayList<>();
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		sessions=sessionRepository.findAll();
		}
		else {
		sessions=sessionRepository.getsessionbyuser(currentuser.getIdutilisateur());
		}
		
		List<SessionDto> sessionDtos=new ArrayList<>();
		for(Session session: sessions) {
			
			ModelMapper modelMapper=new ModelMapper();
			SessionDto sessionDto=modelMapper.map(session, SessionDto.class);
			
			sessionDtos.add(sessionDto);
		}
		
		
		return sessionDtos;
	}

}
