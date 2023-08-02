package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Absence;
import com.example.hps.entity.Session;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.AbsenceRepository;
import com.example.hps.repository.SessionRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.UtilisateurService;

@Service
public class UtilisateurImpl implements UtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	AbsenceRepository absenceRepository;
	@Autowired
	SessionRepository sessionRepository;
	

	@Override
	public UtilisateurDto AjouterUtilisateur(UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
		Utilisateur utilisateurcheckemail=utilisateurRepository.findByemail(utilisateurDto.getEmail());
		Utilisateur utilisateurChecktelephone=utilisateurRepository.findBytelephone(utilisateurDto.getTelephone());
		
		if(utilisateurcheckemail!=null || utilisateurChecktelephone!=null ) throw new RestException("Vous Pouvez pas Ajouté deux utilisateur avec méme email ou bien le méme numéro de téléphone ");
		
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=modelMapper.map(utilisateurDto, Utilisateur.class);
		utilisateur.setEncryptionpassword("dekebfrhgfuyrgi");
		
		 

		Utilisateur utilisateur2=utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto2=modelMapper.map(utilisateur2, UtilisateurDto.class);
		
		return utilisateurDto2;
	}

	@Override
	public UtilisateurDto ModifierUtilisateur(UtilisateurDto utilisateurDto,Long id) {
		// TODO Auto-generated method stub
		
		Utilisateur utilisateurcheck=utilisateurRepository.findByidutilisateur(id);
		if(utilisateurcheck==null) throw new RestException("Ce utiisateur n'existe pas ");
		
		Utilisateur utilisateurcheckemail=utilisateurRepository.findByemail(utilisateurDto.getEmail());
		Utilisateur utilisateurChecktelephone=utilisateurRepository.findBytelephone(utilisateurDto.getTelephone());
		
		if(utilisateurcheckemail!=null || utilisateurChecktelephone!=null ) throw new RestException("Vous Pouvez pas Ajouté deux utilisateur avec méme email ou bien le méme numéro de téléphone ");
		

		
		utilisateurcheck.setEmail(utilisateurDto.getEmail());
		utilisateurcheck.setNom_utilisateur(utilisateurDto.getNom_utilisateur());
		utilisateurcheck.setPrenom_utilisateur(utilisateurcheck.getPrenom_utilisateur());
		utilisateurcheck.setTelephone(utilisateurcheck.getTelephone());
		
		Utilisateur ObjetModifier=utilisateurRepository.save(utilisateurcheck);
		
		ModelMapper modelMapper=new ModelMapper();
		UtilisateurDto utilisateurDto2=modelMapper.map(ObjetModifier, UtilisateurDto.class);
		
		return utilisateurDto2;
	}

	@Override
	public void SupperimerUtilisateur(Long id) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(id);
		if(utilisateur==null) throw new RestException("Ce Utilisateur il n'existe pas");
		utilisateurRepository.delete(utilisateur);
	}

	@Override
	public List<UtilisateurDto> GetAllUser() {
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurs;
		utilisateurs=utilisateurRepository.findAll();
		
		List<UtilisateurDto> utilisateurDtos=new ArrayList<>();
		for(Utilisateur utilisateur: utilisateurs) {
			ModelMapper modelMapper=new ModelMapper();
			UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
			
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}


	@Override
	public UtilisateurDto AjouterAbsenceToUtilisateur(Long iduser, Long idabsence) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		Absence absence=absenceRepository.findByidAbsence(idabsence);
		
		if(utilisateur==null) {throw new RestException("Ce utilisateur n'existe pas ");}
		if(absence==null) {throw new RestException("Ce Absence n'existe pas");}
		utilisateur.AjouterAbsence(utilisateur, absence);
		utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
		
		return utilisateurDto;
	}

	@Override
	public UtilisateurDto SupperimerAbsenceToUtilisateur(Long iduser, Long idabsence) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		Absence absence=absenceRepository.findByidAbsence(idabsence);
		
		if(utilisateur==null) {throw new RestException("Ce utilisateur n'existe pas ");}
		if(absence==null) {throw new RestException("Ce Absence n'existe pas");}
		
		utilisateur.SupperimerAbsence(absence);
		utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);		
		return utilisateurDto;
	}

	@Override
	public UtilisateurDto GetById(Long id) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(id);
		if(utilisateur==null) throw new RestException("Ce Utilisateur n'existe pas");
		
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
		return utilisateurDto;
	}

	@Override
	public Long NombreAbsenceNonJustifier(Long id) {
		// TODO Auto-generated method stub
		return absenceRepository.AbsenceNonJustifier(id);
	}

	@Override
	public Long NombreAbsenceJustifier(Long id) {
		// TODO Auto-generated method stub
		
		return absenceRepository.AbsenceJustifier(id);
	}

	@Override
	public Long GetCountUser() {
		// TODO Auto-generated method stub
		return utilisateurRepository.getCountUser();
	}

	@Override
	public Long GetCountAbsence() {
		// TODO Auto-generated method stub
		return absenceRepository.GetCountAbsence();
	}

	@Override
	public List<UtilisateurDto> GetUserWhereGroupeNull() {
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurs= utilisateurRepository.GetUserwhereGroupeIsNull();
		List<UtilisateurDto> utilisateurDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		
		for (Utilisateur utilisateur : utilisateurs) {
			UtilisateurDto utilisateurDto= modelMapper.map(utilisateur, UtilisateurDto.class);
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}

	@Override
	public List<UtilisateurDto> GetUser_Group(Long id) {
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurs=utilisateurRepository.GetUser_Group(id);
		List<UtilisateurDto> utilisateurDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		
		for(Utilisateur utilisateur: utilisateurs) {
			UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}

	@Override
	public UtilisateurDto AjouterSessionToUtilisateur(long iduser, Long idsession) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		Session session=sessionRepository.findByidsession(idsession);
		
		if(utilisateur==null) {throw new RestException("Ce utilisateur n'existe pas ");}
		if(session==null) {throw new RestException("Cetet session n'existe pas");}	
		
		utilisateur.AjouterSession(utilisateur, session);
		utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
		
		return utilisateurDto;
	}

	@Override
	public UtilisateurDto SupperimerSessionToUser(long iduser,long idsession) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		Session session=sessionRepository.findByidsession(idsession);
		
		if(utilisateur==null) {throw new RestException("Ce utilisateur n'existe pas ");}
		if(session==null) {throw new RestException("Cetet session n'existe pas");}	
		
		utilisateur.SupperimerSession(session);
		utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateur,UtilisateurDto.class );
		return utilisateurDto;
		
	}
	

}
