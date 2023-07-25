package com.example.hps.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.PlanificationDto;
import com.example.hps.entity.Planification;
import com.example.hps.repository.PlanificationRepository;
import com.example.hps.request.PlanificationRequest;
import com.example.hps.response.PlanificationResponse;
import com.example.hps.service.PlanificationService;

@RestController
@RequestMapping("Planification")
@CrossOrigin("http://localhost:4200")
public class PlanificationController {
	
	@Autowired
	private PlanificationService planificationService;

	
	@GetMapping
	public ResponseEntity<List<PlanificationResponse>> GetAll(){
		
		List<PlanificationResponse> planificationResponses=new ArrayList<>();
		
		List<PlanificationDto> planificationDtos=planificationService.GetAllPlaning();
		
		for(PlanificationDto planificationDto: planificationDtos) {
			ModelMapper modelMapper=new ModelMapper();
			PlanificationResponse planificationResponse=modelMapper.map(planificationDto, PlanificationResponse.class);
			
			planificationResponses.add(planificationResponse);
		}
		return new ResponseEntity<List<PlanificationResponse>>(planificationResponses,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<PlanificationResponse> Ajouter(@RequestBody PlanificationRequest planificationRequest) throws Exception{
		ModelMapper modelMapper=new ModelMapper();
		PlanificationDto planificationDto=modelMapper.map(planificationRequest, PlanificationDto.class);
		
		PlanificationDto createPlanification=planificationService.AjouterPlanification(planificationDto);
		PlanificationResponse planificationResponse=modelMapper.map(createPlanification, PlanificationResponse.class);
				
		return new ResponseEntity<PlanificationResponse>(planificationResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<PlanificationResponse> Modifier(@RequestBody PlanificationRequest planificationRequest,@PathVariable Long id){
		
		ModelMapper modelMapper=new ModelMapper();
		
		PlanificationDto planificationDto=modelMapper.map(planificationRequest, PlanificationDto.class);
		
		PlanificationDto planificationModifier= planificationService.ModifierPlanification(planificationDto, id);
		
		PlanificationResponse planificationResponse=modelMapper.map(planificationModifier, PlanificationResponse.class);
		return new ResponseEntity<PlanificationResponse>(planificationResponse,HttpStatus.CREATED);
	}
	
	
	  @DeleteMapping(path = "/{id}") public ResponseEntity<Object>
	  Delete(@PathVariable LocalDate date) throws Exception{
	  
	  planificationService.SupperimerPlanification(date); return new
	  ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 
	
	@GetMapping("/AffecteSessionToPlanification/{idsession}/{idPlani}")
	public ResponseEntity<PlanificationResponse> AffecteSessionToPlanification(@PathVariable Long idsession,@PathVariable Long idPlani){
		
		ModelMapper modelMapper=new ModelMapper();
		
		PlanificationDto planificationDto=planificationService.AffecteSessionToplanification(idsession, idPlani);
		PlanificationResponse planificationResponse=modelMapper.map(planificationDto, PlanificationResponse.class);
		
		return new ResponseEntity<PlanificationResponse>(planificationResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/SupperimerSessionToPlanification/{idsession}/{idPlani}")
	public ResponseEntity<PlanificationResponse> DropSessionToPlanification(@PathVariable Long idsession,@PathVariable Long idPlani){
		ModelMapper modelMapper=new ModelMapper();
		
		PlanificationDto planificationDto=planificationService.SupperimerSessionToPlanification(idsession, idPlani);
		PlanificationResponse planificationResponse=modelMapper.map(planificationDto, PlanificationResponse.class);
		
		
	return new ResponseEntity<PlanificationResponse>(planificationResponse,HttpStatus.ACCEPTED);
	}
}
