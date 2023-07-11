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

import com.example.hps.dto.GroupeDto;
import com.example.hps.request.GroupeRequest;
import com.example.hps.response.GroupeResponse;
import com.example.hps.service.GroupeService;

@RestController
@RequestMapping("Groupe")
public class GroupeController {
	@Autowired 
	private GroupeService groupeService;
	
	
	@PostMapping
	public ResponseEntity<GroupeResponse> Ajouter(@RequestBody GroupeRequest groupeRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		GroupeDto groupeDto=modelMapper.map(groupeRequest, GroupeDto.class);
		
		GroupeDto createGroupe=groupeService.AjouterGroupe(groupeDto);
		GroupeResponse groupeResponse=modelMapper.map(createGroupe, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<GroupeResponse> Update(@RequestBody GroupeRequest groupeRequest,@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		
		GroupeDto groupeDto=modelMapper.map(groupeRequest, GroupeDto.class);
		GroupeDto ModificationGroupe=groupeService.ModifierGroupe(groupeDto, id);
		
		GroupeResponse groupeResponse=modelMapper.map(ModificationGroupe, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<GroupeResponse>> GetALLGroupe(){
		List<GroupeResponse> groupeResponses=new ArrayList<>();
		
		List<GroupeDto> groupeDtos=groupeService.GetAllGroupe();
		
		for(GroupeDto groupeDto:groupeDtos) {
			ModelMapper modelMapper=new ModelMapper();
			GroupeResponse groupeResponse=modelMapper.map(groupeDto, GroupeResponse.class);
			
			groupeResponses.add(groupeResponse);
		}
		
		return new ResponseEntity<List<GroupeResponse>>(groupeResponses,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Supperimer(@PathVariable Long id){
		groupeService.SupperimerGroupe(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	

}
