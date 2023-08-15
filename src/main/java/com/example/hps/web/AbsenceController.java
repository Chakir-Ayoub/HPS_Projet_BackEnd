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

import com.example.hps.dto.AbsenceDto;
import com.example.hps.request.AbsenceRequest;
import com.example.hps.response.AbsenceResponse;
import com.example.hps.service.AbsenceService;

@RestController
@RequestMapping("Absence")
public class AbsenceController {
	
	@Autowired
	private AbsenceService absenceService;
	
	@GetMapping
	public ResponseEntity<List<AbsenceResponse>> GetAll(){
		
		List<AbsenceResponse> absenceResponses=new ArrayList<>();
		
		List<AbsenceDto> absenceDtos=absenceService.GetAll();
		for(AbsenceDto absenceDto: absenceDtos) {
			ModelMapper modelMapper=new ModelMapper();
			AbsenceResponse absenceResponse	=modelMapper.map(absenceDto, AbsenceResponse.class);
			
			absenceResponses.add(absenceResponse);
		}
		return new ResponseEntity<List<AbsenceResponse>>(absenceResponses,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<AbsenceResponse> Ajouter(@RequestBody AbsenceRequest absenceRequest){
		ModelMapper modelMapper=new ModelMapper();
		AbsenceDto absenceDto=modelMapper.map(absenceRequest, AbsenceDto.class);
		
		AbsenceDto absenceDto2=absenceService.AjouterAbsence(absenceDto);
		AbsenceResponse absenceResponse=modelMapper.map(absenceDto2, AbsenceResponse.class);
		
		return new ResponseEntity<AbsenceResponse>(absenceResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<AbsenceResponse> Update(@RequestBody AbsenceRequest absenceRequest, @PathVariable Long id){
		
		ModelMapper  modelMapper=new ModelMapper();
		
		AbsenceDto absenceDto=modelMapper.map(absenceRequest, AbsenceDto.class);
		AbsenceDto ModificationAbsence=absenceService.ModifierAbsence(absenceDto, id);
		
		AbsenceResponse absenceResponse=modelMapper.map(ModificationAbsence, AbsenceResponse.class);
		
		return new ResponseEntity<AbsenceResponse>(absenceResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable Long id){
		absenceService.SupperimerAbsence(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AbsenceResponse> GetById(@PathVariable Long id){
		AbsenceDto absenceDto= absenceService.GetById(id);
		ModelMapper modelMapper=new ModelMapper();
		AbsenceResponse absenceResponse=modelMapper.map(absenceDto, AbsenceResponse.class);
		
		return new ResponseEntity<AbsenceResponse>(absenceResponse,HttpStatus.OK);
	}
	
}
