package com.example.hps.web;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class PlanificationController {
	
	@Autowired
	private PlanificationService planificationService;
	@Autowired 
	private PlanificationRepository planificationRepository;
	
	@GetMapping
	public List<Planification> GetAll(){
		return planificationRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<PlanificationResponse> Ajouter(@RequestBody PlanificationRequest planificationRequest) throws Exception{
		ModelMapper modelMapper=new ModelMapper();
		PlanificationDto planificationDto=modelMapper.map(planificationRequest, PlanificationDto.class);
		
		PlanificationDto createPlanification=planificationService.AjouterPlanification(planificationDto);
		PlanificationResponse planificationResponse=modelMapper.map(createPlanification, PlanificationResponse.class);
				
		return new ResponseEntity<PlanificationResponse>(planificationResponse,HttpStatus.ACCEPTED);
	}
	
}
