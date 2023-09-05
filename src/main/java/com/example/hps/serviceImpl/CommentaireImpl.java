package com.example.hps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.dto.CommentaireDto;
import com.example.hps.entity.Commentaire;
import com.example.hps.repository.CommentaireRepository;
import com.example.hps.service.CommentaireService;

@Service
public class CommentaireImpl implements CommentaireService {
	
	@Autowired
	CommentaireRepository commentaireRepository;
	@Override
	public CommentaireDto AddCommentaire(CommentaireDto commentaireDto) {
		// TODO Auto-generated method stub
		
		ModelMapper modelMapper =new ModelMapper();
		//commentaireDto.setProjet(commentaireDto.getProjet());
		Commentaire commentaire=modelMapper.map(commentaireDto, Commentaire.class);
		commentaire.setDate(LocalDate.now());
	//	commentaire.getProjet().AddComment(commentaire, commentaire.getProjet());
		
		Commentaire commentaire22=new Commentaire(null, commentaire.getComentaire(), commentaire.getDate(), commentaire.getProjet());
		Commentaire commentaire2= commentaireRepository.save(commentaire22);
		
		CommentaireDto commentaireDTO=modelMapper.map(commentaire2, CommentaireDto.class);

		return commentaireDTO;
	}

	@Override
	public void DeleteCommentaire(Long id) {
		// TODO Auto-generated method stub
		Commentaire commentaire=commentaireRepository.findByid(id);
		commentaireRepository.delete(commentaire);
	}

	@Override
	public List<CommentaireDto> getall() {
		// TODO Auto-generated method stub
		List<Commentaire> commentaire=commentaireRepository.findAll();
		ModelMapper modelMapper=new ModelMapper();
		List<CommentaireDto> commentaireDtos=new ArrayList<>();
		for (Commentaire commentaire1 : commentaire) {
			CommentaireDto commentaireDtoo=modelMapper.map(commentaire1, CommentaireDto.class);
			commentaireDtos.add(commentaireDtoo);
		}
		
		return commentaireDtos;
	}

	@Override
	public List<CommentaireDto> getAllCommentairebysession(Long idsession) {
		// TODO Auto-generated method stub
		List<Commentaire> commentaires=commentaireRepository.getAllCommentairebysession(idsession);
		
		ModelMapper modelMapper=new ModelMapper();
		List<CommentaireDto> commentaireDtos=new ArrayList<>();
		for (Commentaire commentaire:commentaires) {
			CommentaireDto commentaireDtoo=modelMapper.map(commentaire, CommentaireDto.class);
			commentaireDtos.add(commentaireDtoo);			
		}
		return commentaireDtos;
	}

}
