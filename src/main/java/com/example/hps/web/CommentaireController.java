package com.example.hps.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.CommentaireDto;
import com.example.hps.request.CommentaireRequest;
import com.example.hps.response.CommentaireResponse;
import com.example.hps.service.CommentaireService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("Commentaire")
public class CommentaireController {
	
	@Autowired
	CommentaireService commentaireService;
	
	@PostMapping
	public ResponseEntity<CommentaireResponse> AddCommentaire(@RequestBody CommentaireRequest commentaireRequest ){
		ModelMapper modelMapper=new ModelMapper();
		CommentaireDto commentaireDto=modelMapper.map(commentaireRequest, CommentaireDto.class);
		CommentaireDto commentaireDto2=commentaireService.AddCommentaire(commentaireDto);
		
		CommentaireResponse commentaireResponse=modelMapper.map(commentaireDto2, CommentaireResponse.class);
		return new ResponseEntity<CommentaireResponse>(commentaireResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> DeleteCommentaire(@PathVariable Long id){
		commentaireService.DeleteCommentaire(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CommentaireResponse>> GetAll(){
		List<CommentaireDto> commentaireDtos=commentaireService.getall();
		ModelMapper modelMapper=new ModelMapper();
		List<CommentaireResponse> commentaireResponses=new ArrayList<>();
		for (CommentaireDto commentaireDto : commentaireDtos) {
			CommentaireResponse commentaireResponse=modelMapper.map(commentaireDto, CommentaireResponse.class);
			commentaireResponses.add(commentaireResponse);
		}
		return new ResponseEntity<List<CommentaireResponse>>(commentaireResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getbysession/{idsession}")
	public ResponseEntity<List<CommentaireResponse>> GetAllBySession(@PathVariable Long idsession){
		List<CommentaireDto> commentaireDtos=commentaireService.getAllCommentairebysession(idsession);
		ModelMapper modelMapper=new ModelMapper();
		
		List<CommentaireResponse> commentaireResponses=new ArrayList<>();
		for (CommentaireDto commentaireDto : commentaireDtos) {
			CommentaireResponse commentaireResponse=modelMapper.map(commentaireDto, CommentaireResponse.class);
			commentaireResponses.add(commentaireResponse);
		}
		return new ResponseEntity<List<CommentaireResponse>>(commentaireResponses,HttpStatus.ACCEPTED);
	}
}
