package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.GroupeDto;
import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Groupe;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.GroupeRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.request.UtilisateurRequest;
import com.example.hps.service.UtilisateurService;

@Service
public class UtilisateurImpl implements UtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	GroupeRepository groupeRepository;

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
		

		
		utilisateurcheck.setDate_naiss(utilisateurDto.getDate_naiss());
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
	public void AffecteUserToGroupe(String emailutilisateur, String nomgroupe) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=utilisateurRepository.findByemail(emailutilisateur);
		Groupe groupe=groupeRepository.findBynomgroupe(nomgroupe);
		groupe.setUtilisateurs((List<Utilisateur>) utilisateur);
		 
	}
	

}
