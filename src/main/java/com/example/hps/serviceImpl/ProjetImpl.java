package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.ProjetDto;
import com.example.hps.entity.Projet;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.ProjetRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.ProjetService;


@Service
public class ProjetImpl implements ProjetService {
	
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public ProjetDto AjouterProjet(ProjetDto projet,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		Projet projetCheck = projetRepository.findBynomprojet(projet.getNomprojet());
		
		if (projetCheck != null) throw new RestException("Ce Projet existe déjà !");

		
		 
		
		ModelMapper modelMapper = new ModelMapper();
		projet.setSoftdelete(true);
		Projet projett = modelMapper.map(projet, Projet.class);


		
		Projet newProjet = projetRepository.save(projett); //DAO 
		
		ProjetDto projetDto2 = modelMapper.map(newProjet, ProjetDto.class);
		return projetDto2;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}

		
	}

	@Override
	public ProjetDto ModifierProjet(ProjetDto projetDto,Long id,String email) {

		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		Projet projetCheck=projetRepository.findByidprojet(id);
		if(projetCheck==null) throw new RestException("Ce Projet il n'existe pas !");
		
		ModelMapper modelMapper=new ModelMapper();
		Projet modifierObjetProjet= modelMapper.map(projetDto, Projet.class);
		
		projetCheck.setDatedemarrage(modifierObjetProjet.getDatedemarrage());
		projetCheck.setDescription(modifierObjetProjet.getDescription());
		if(projetRepository.findBynomprojet(projetDto.getNomprojet())==null)  
		{
			projetCheck.setNomprojet(modifierObjetProjet.getNomprojet());
	
		}
		else {
			 throw new RestException("Ce Nom de Projet Il existe Déja ");

		}
		
		
		Projet ObjetModifier=projetRepository.save(projetCheck);
		
		ProjetDto projetDto2=modelMapper.map(ObjetModifier, ProjetDto.class);
		
		return projetDto2;
		}else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}


}


	@Override
	public void SupperimerProjet(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 ) {
		Projet projetCheck=projetRepository.findByidprojet(id);
		if(projetCheck==null) throw new RuntimeException("Ce Projet il n'existe pas !");
		
		projetRepository.delete(projetCheck);}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public List<ProjetDto> GetAllProjet(String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Projet> projets=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		projets=projetRepository.findAll();
		}else {
			projets=projetRepository.GetProjectByUser(currentuser.getIdutilisateur());	
		}
		
		List<ProjetDto> projetsDtos=new ArrayList<>();
		for (Projet projet : projets) {

			ModelMapper modelMapper=new ModelMapper();
			ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
			
			projetsDtos.add(projetDto);
			
			
		}
		
		return projetsDtos;
		}
	





	@Override
	public ProjetDto GetById(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		ModelMapper modelMapper=new ModelMapper();
		
		Projet projet=projetRepository.findByidprojet(id);
		
		ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
		
		return projetDto;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public Long GetCountProject() {
		// TODO Auto-generated method stub
		return projetRepository.GetCountProject();
	}

	@Override
	public Long GetProjectStar() {
		// TODO Auto-generated method stub
		return projetRepository.GetStartProject();
	}

	@Override
	public ProjetDto GetProjectBysesssion(Long idsession,String email) {
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Projet projet=projetRepository.GetProjectBySession(idsession);
		if(projet==null) throw new RestException("Aucun projet n'est affecté à cette session.");
		ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
		
		return projetDto;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void DropProjectByDate(String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		this.projetRepository.DropProjectByDate();	
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	

}
