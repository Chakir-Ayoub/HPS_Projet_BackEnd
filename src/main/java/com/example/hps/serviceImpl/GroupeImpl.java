package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.GroupeDto;
import com.example.hps.entity.Groupe;
import com.example.hps.entity.Sous_Groupe;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.GroupeRepository;
import com.example.hps.repository.Sous_GroupeRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.GroupeService;


@Service
public class GroupeImpl implements GroupeService {

	@Autowired
	GroupeRepository groupeRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	Sous_GroupeRepository sous_GroupeRepository;
	@Override
	public GroupeDto AjouterGroupe(GroupeDto groupeDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 ) {
		Groupe groupecheck=groupeRepository.findBynomgroupe(groupeDto.getNomgroupe());
		if(groupecheck!=null) throw new RestException("Ce groupe il existe déja");
		
		ModelMapper modelMapper=new ModelMapper();
		Groupe groupe=modelMapper.map(groupeDto, Groupe.class);
		
		Groupe  groupe2=groupeRepository.save(groupe);
		GroupeDto groupeDto2=modelMapper.map(groupe2, GroupeDto.class);
		
		
		return groupeDto2;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public GroupeDto ModifierGroupe(GroupeDto groupeDto,Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Groupe groupecheck=groupeRepository.findByidgroup(id);
		if(groupecheck==null) throw new RestException("Ce groupe n'existe pas ");
		
		groupecheck.setNomgroupe(groupeDto.getNomgroupe());
		
		
		ModelMapper modelMapper=new ModelMapper();
		Groupe groupe=groupeRepository.save(groupecheck);
		GroupeDto groupeDto2=modelMapper.map(groupe, GroupeDto.class);
		
		
				
		return groupeDto2;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void SupperimerGroupe(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7) {
		Groupe groupe=groupeRepository.findByidgroup(id);
		if(groupe==null) throw new RestException("Ce groupe n'existe pas ");
		
		groupeRepository.delete(groupe);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}

	}

	@Override
	public List<GroupeDto> GetAllGroupe(String email) {
		// TODO Auto-generated method stub
		List<Groupe> groupes=new ArrayList<>();
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==7 ) {
		groupes = groupeRepository.findAll();
		}
		else {
			groupes=groupeRepository.getgroupbyuser(currentuser.getIdutilisateur());
		}
		ModelMapper modelMapper=new ModelMapper();

		List<GroupeDto> groupeDtos=new ArrayList<>();
		for(Groupe groupe: groupes) {
			GroupeDto groupeDto=modelMapper.map(groupe, GroupeDto.class);
			
			groupeDtos.add(groupeDto);
		}
		
		return groupeDtos;
	}

	@Override
	public GroupeDto Affecte_Utilisateur_Groupe(Long iduser,Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==7 ) {
		ModelMapper modelMapper=new ModelMapper();
		
		Groupe groupe=groupeRepository.findByidgroup(id);
		Utilisateur utilisateur=utilisateurRepository.findByidutilisateur(iduser);
		if(groupe==null) {throw new RestException("Ce groupe n'existe pas ");}
		utilisateur.setEncryptionpassword("dehdvr");
		groupe.AddUtilisateur(utilisateur, groupe);
		
		groupeRepository.save(groupe);
		GroupeDto groupeDto=modelMapper.map(groupe,GroupeDto.class);
		return groupeDto;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public GroupeDto GetById(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==7 ) {
		ModelMapper modelMapper=new ModelMapper();
		
		Groupe groupe=groupeRepository.findByidgroup(id);
		if(groupe==null) throw new RestException("Ce Groupe n'existe pas");
		GroupeDto groupeDto=modelMapper.map(groupe, GroupeDto.class);
		return groupeDto;
		}else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public GroupeDto Supperimer_User_Groupe(Long idgroupe, Long iduser,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==7 ) {

	    ModelMapper modelMapper = new ModelMapper();
	    Groupe groupe = groupeRepository.findByidgroup(idgroupe);
	    
	    if (groupe != null) {
	        Utilisateur utilisateur = utilisateurRepository.findByidutilisateur(iduser);
	        groupe.Removeutilisateur(utilisateur);
	        groupeRepository.save(groupe);
	        
	        GroupeDto groupeDto = modelMapper.map(groupe, GroupeDto.class);
	        return groupeDto;
	    } else {
	        throw new RestException("Ce utilisateur n'xiste pas dans Ce groupe");
	    }
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public GroupeDto Affecte_Sous_Group_Groupe(Sous_Groupe sousGroupe, Long id) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		
		Groupe groupe=groupeRepository.findByidgroup(id);
		if(groupe==null) {throw new RestException("Ce groupe n'existe pas ");}
		groupe.AddSousGroupe(sousGroupe, groupe);

		groupeRepository.save(groupe);
		
		GroupeDto groupeDto=modelMapper.map(groupe, GroupeDto.class);
		return groupeDto;
	}

	@Override
	public GroupeDto Supperimer_Sous_groupe_Groupe(Long idgroupe, Long idsousgroupe) {
		// TODO Auto-generated method stub
		 ModelMapper modelMapper = new ModelMapper();
		    Groupe groupe = groupeRepository.findByidgroup(idgroupe);
		    
		    if (groupe != null) {
		        Sous_Groupe sous_Groupe = sous_GroupeRepository.findByidsousgroupe(idsousgroupe);
		        groupe.Removesous_groupe(sous_Groupe);
		        groupeRepository.save(groupe);
		        
		        GroupeDto groupeDto = modelMapper.map(groupe, GroupeDto.class);
		        return groupeDto;
		    } else {
		        throw new RestException("Ce Sous Groupe n'xiste pas dans Ce groupe");
		    }
	}

	@Override
	public Long GetCountUserInGroupe(Long id) {
		// TODO Auto-generated method stub
		if(groupeRepository.findByidgroup(id)==null) throw new RestException("Ce groupe n'existe pas");
		return groupeRepository.getCountUserInGroupe(id) ;
	}
	
	

}
