package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.DetailDto;
import com.example.hps.dto.ProjetDto;
import com.example.hps.entity.Detail;
import com.example.hps.entity.Projet;
import com.example.hps.repository.DetailRepository;
import com.example.hps.repository.ProjetRepository;
import com.example.hps.service.ProjetService;

@Service
public class ProjetImpl implements ProjetService {
	
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	DetailRepository detailRepository;

	@Override
	public ProjetDto AjouterProjet(ProjetDto projet) {
		// TODO Auto-generated method stub
		Projet projetCheck = projetRepository.findBynomprojet(projet.getNomprojet());
		if (projetCheck != null) throw new RestException("Ce Projet existe déjà !");

		
		
		for (int i = 0; i < projet.getDetails().size(); i++) {
		    DetailDto detailDto = projet.getDetails().get(i);
			detailDto.setProjet(projet);
		    projet.getDetails().set(i, detailDto);
		}
		
		ModelMapper modelMapper = new ModelMapper();

		Projet projett = modelMapper.map(projet, Projet.class);



		Projet newProjet = projetRepository.save(projett); //DAO 
		
		ProjetDto projetDto2 = modelMapper.map(newProjet, ProjetDto.class);
		return projetDto2;

		
	}

	@Override
	public ProjetDto ModifierProjet(ProjetDto projetDto,Long id) {
		// TODO Auto-generated method stub
		Projet projetCheck=projetRepository.findByidprojet(id);
		if(projetCheck==null) throw new RestException("Ce Projet il n'existe pas !");
		
		ModelMapper modelMapper=new ModelMapper();
		Projet modifierObjetProjet= modelMapper.map(projetDto, Projet.class);
		
		projetCheck.setDatedemarrage(modifierObjetProjet.getDatedemarrage());
		projetCheck.setDatelivraison(modifierObjetProjet.getDatelivraison());
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
		
		}

	@Override
	public void SupperimerProjet(Long id) {
		// TODO Auto-generated method stub
		Projet projetCheck=projetRepository.findByidprojet(id);
		if(projetCheck==null) throw new RuntimeException("Ce Projet il n'existe pas !");
		
		projetRepository.delete(projetCheck);
	}

	@Override
	public List<ProjetDto> GetAllProjet() {
		// TODO Auto-generated method stub
		List<Projet> projets;
		projets=projetRepository.findAll();
		
		List<ProjetDto> projetsDtos=new ArrayList<>();
		for (Projet projet : projets) {

			ModelMapper modelMapper=new ModelMapper();
			ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
			
			projetsDtos.add(projetDto);
			
			
		}
		
		return projetsDtos;
	}

	@Override
	public ProjetDto AjouterDetailToProjet(Long iddetail, Long idprojet) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Detail detail=detailRepository.findByiddetail(iddetail);
		Projet projet=projetRepository.findByidprojet(idprojet);
		
		projet.AddDetails(detail, projet);
		
		projetRepository.save(projet);
		ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
		
		return projetDto;
	}

	@Override
	public ProjetDto SupperimerDetailToProjet(Long iddetail, Long idprojet) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Detail detail=detailRepository.findByiddetail(iddetail);
		Projet projet=projetRepository.findByidprojet(idprojet);
		
		projet.RemoveDetails(detail);
		
		projetRepository.save(projet);
		ProjetDto projetDto=modelMapper.map(projet, ProjetDto.class);
		
		
		return projetDto;
	}

	

}
