package com.example.hps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.AbsenceDto;
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
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UtilisateurDto AjouterUtilisateur(UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
		/*Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {*/
		Utilisateur utilisateurcheckemail=utilisateurRepository.findByemail(utilisateurDto.getEmail());
		Utilisateur utilisateurChecktelephone=utilisateurRepository.findBytelephone(utilisateurDto.getTelephone());
		
		if(utilisateurcheckemail!=null || utilisateurChecktelephone!=null ) throw new RestException("Vous Pouvez pas Ajouté deux utilisateur avec méme email ou bien le méme numéro de téléphone ");
		
		ModelMapper modelMapper=new ModelMapper();
		
		Utilisateur utilisateur=modelMapper.map(utilisateurDto, Utilisateur.class);
		utilisateur.setEncryptionpassword(bCryptPasswordEncoder.encode(utilisateurDto.getPassword()));
		 

		Utilisateur utilisateur2=utilisateurRepository.save(utilisateur);
		
		UtilisateurDto utilisateurDto2=modelMapper.map(utilisateur2, UtilisateurDto.class);
		
		return utilisateurDto2;
		}
	/*	else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}*/
	//}

	@Override
	public UtilisateurDto ModifierUtilisateur(UtilisateurDto utilisateurDto,Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		Utilisateur utilisateurcheck=utilisateurRepository.findByidutilisateur(id);
		if(utilisateurcheck==null) throw new RestException("Ce utiisateur n'existe pas ");
		ModelMapper modelMapper=new ModelMapper();

		Utilisateur utilisateurcheckemail=utilisateurRepository.findByemail(utilisateurDto.getEmail());
		Utilisateur utilisateurChecktelephone=utilisateurRepository.findBytelephone(utilisateurDto.getTelephone());
		
	//	if(utilisateurcheckemail!=null || utilisateurChecktelephone!=null ) throw new RestException("Vous Pouvez pas Ajouté deux utilisateur avec méme email ou bien le méme numéro de téléphone ");
		
		Utilisateur utilisateur=modelMapper.map(utilisateurDto,Utilisateur.class);
		
		utilisateurcheck.setEmail(utilisateurDto.getEmail());
		utilisateurcheck.setNom_utilisateur(utilisateurDto.getNom_utilisateur());
		utilisateurcheck.setPrenom_utilisateur(utilisateurcheck.getPrenom_utilisateur());
		utilisateurcheck.setTelephone(utilisateurcheck.getTelephone());
		utilisateurcheck.setGroupe(utilisateur.getGroupe());
		utilisateurcheck.setRole(utilisateur.getRole());
		Utilisateur ObjetModifier=utilisateurRepository.save(utilisateurcheck);
		
		UtilisateurDto utilisateurDto2=modelMapper.map(ObjetModifier, UtilisateurDto.class);
		
		return utilisateurDto2;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void SupperimerUtilisateur(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 ) {
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(id);
		if(utilisateur==null) throw new RestException("Ce Utilisateur il n'existe pas");
		utilisateurRepository.delete(utilisateur);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public List<UtilisateurDto> GetAllUser(String email) {
		
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Utilisateur> utilisateurs=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==1) {
			utilisateurs=utilisateurRepository.findAll();	
		}
		else if(currentuser.getRole().getIdRole()==2) {
			utilisateurs=utilisateurRepository.getAllUsersByGroupe(Long.valueOf(2));
		}

		List<UtilisateurDto> utilisateurDtos=new ArrayList<>();
		for(Utilisateur utilisateur: utilisateurs) {
			ModelMapper modelMapper=new ModelMapper();
			UtilisateurDto utilisateurDto=modelMapper.map(utilisateur, UtilisateurDto.class);
			
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}


	@Override
	public UtilisateurDto AjouterAbsenceToUtilisateur(Long iduser,AbsenceDto absenceDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		LocalDate currentdate=LocalDate.now();

		if(currentdate.isAfter(absenceDto.getDate_debut())) {throw new RestException("La date de Debut n'est pas acceptée ");}
		if(currentdate.isAfter(absenceDto.getDate_fin())) {throw new RestException("La date de Fin n'est pas acceptée ");}
		if (currentdate.isEqual(absenceDto.getDate_fin())) { throw new RestException("La date de Fin  est la même que la date actuelle.");}
		
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		Absence absence=modelMapper.map(absenceDto, Absence.class);
		
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

	@Override
	public UtilisateurDto GetUserBySession(Long idsession) {
		// TODO Auto-generated method stub
		
		  ModelMapper modelMapper=new ModelMapper();
		  
		  Utilisateur utilisateur=utilisateurRepository.getUser_Session(idsession);
		  
		  if(utilisateur==null) throw new RestException("Ce Utilisateur n'existe pas");
		  
		  UtilisateurDto utilisateurDto=modelMapper.map(utilisateur,
		  UtilisateurDto.class);
		  
		  return utilisateurDto;
		 
	}

	@Override
	public UtilisateurDto getUser(String email) {
		// TODO Auto-generated method stub
		Utilisateur userEntity=utilisateurRepository.findByemail(email);
		if(userEntity==null) throw new RuntimeException("User Not Exist");
		UtilisateurDto dto=new UtilisateurDto();
		BeanUtils.copyProperties(userEntity, dto);		
		return dto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur userEntity=utilisateurRepository.findByemail(email);
		if(userEntity==null) throw new RuntimeException(email);
		return new User(userEntity.getEmail(),userEntity.getEncryptionpassword(), new ArrayList<>());	
	}

	@Override
	public List<UtilisateurDto> getusersbyrole(String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Utilisateur> utilisateurs=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==1) {
			utilisateurs=utilisateurRepository.getUsersByRole(Long.valueOf(3));
		}
		else if(currentuser.getRole().getIdRole()==2) {
			utilisateurs=utilisateurRepository.getUsersByRole(Long.valueOf(3));
		}
		List<UtilisateurDto> utilisateurDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Utilisateur utilisateur : utilisateurs) {
			UtilisateurDto utilisateurDto= modelMapper.map(utilisateur, UtilisateurDto.class);
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}

	@Override
	public List<Utilisateur> GetIdUsers() {
		// TODO Auto-generated method stub
		List<Utilisateur> GetAll=utilisateurRepository.GetIdUsers();
		return GetAll;
	}

	@Override
	public List<String> GetnameUsers() {
		// TODO Auto-generated method stub
		List<String> nom=utilisateurRepository.GetnameUsers();
		return nom;
	}
	
	

}
