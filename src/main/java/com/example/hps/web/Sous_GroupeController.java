package com.example.hps.web;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.Sous_GroupeDto;
import com.example.hps.request.Sous_groupeRequest;
import com.example.hps.response.Sous_GroupeResponse;
import com.example.hps.service.Sous_GroupeService;

@RestController
@RequestMapping("Sous_Groupe")
public class Sous_GroupeController {
	
	@Autowired
	private Sous_GroupeService sous_GroupeService;
	
	
	@PostMapping
	public ResponseEntity<Sous_GroupeResponse> Ajouter(@RequestBody Sous_groupeRequest groupeRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		Sous_GroupeDto groupeDto=modelMapper.map(groupeRequest, Sous_GroupeDto.class);
		
		Sous_GroupeDto groupeDto2=sous_GroupeService.AjouterSous_Groupe(groupeDto);
		Sous_GroupeResponse sous_GroupeResponse=modelMapper.map(groupeDto2, Sous_GroupeResponse.class);
		
		
		return new ResponseEntity<Sous_GroupeResponse>(sous_GroupeResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<Sous_GroupeResponse>> GetAll(){
		List<Sous_GroupeResponse> groupeResponses=new ArrayList<>();
		
		List<Sous_GroupeDto> groupeDtos=sous_GroupeService.GetAllSous_Groupe();
		
		for(Sous_GroupeDto sous_GroupeDto:groupeDtos) {
			ModelMapper modelMapper=new ModelMapper();
			Sous_GroupeResponse groupeResponse=modelMapper.map(sous_GroupeDto, Sous_GroupeResponse.class);
			
			groupeResponses.add(groupeResponse);
		}
		return new ResponseEntity<List<Sous_GroupeResponse>>(groupeResponses,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Sous_GroupeResponse> Modifier(@RequestBody Sous_groupeRequest sousgroupeRequest ,@PathVariable Long id){
		
		ModelMapper modelMapper=new ModelMapper();
		
		Sous_GroupeDto sousGroupeDto=modelMapper.map(sousgroupeRequest, Sous_GroupeDto.class);
		Sous_GroupeDto ModifierSous_groupe=sous_GroupeService.ModifierSous_Groupe(sousGroupeDto, id);
		
		Sous_GroupeResponse sousgroupeResponse=modelMapper.map(ModifierSous_groupe, Sous_GroupeResponse.class);
		
		
		return new ResponseEntity<Sous_GroupeResponse>(sousgroupeResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Supperimer(@PathVariable Long id){
		sous_GroupeService.SupperimerSous_Groupe(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
