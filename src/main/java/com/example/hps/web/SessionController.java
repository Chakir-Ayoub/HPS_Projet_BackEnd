package com.example.hps.web;

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

import com.example.hps.dto.SessionDto;
import com.example.hps.request.SessionRequest;
import com.example.hps.response.SessionResponse;
import com.example.hps.service.SessionService;

@RestController
@RequestMapping("Session")
@CrossOrigin("http://localhost:4200")
public class SessionController{

	@Autowired 
	private SessionService sessionService;
	
	@PostMapping
	public ResponseEntity<SessionResponse> Ajouter(@RequestBody SessionRequest sessionRequest) throws Exception{
		
		ModelMapper modelMapper=new ModelMapper();
		SessionDto sessionDto=modelMapper.map(sessionRequest, SessionDto.class);
		
		SessionDto CreateSession=sessionService.AjouterSession(sessionDto);
		SessionResponse sessionResponse=modelMapper.map(CreateSession, SessionResponse.class);
		
		return new ResponseEntity<SessionResponse>(sessionResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<SessionResponse>> GetAllSession(){
		List<SessionResponse> sessionResponses=new ArrayList<>();
		
		List<SessionDto> sessionDtos=sessionService.GetAllSession();
		
		for(SessionDto sessionDto: sessionDtos) {
			ModelMapper modelMapper=new ModelMapper();
			SessionResponse session=modelMapper.map(sessionDto, SessionResponse.class);
			
			sessionResponses.add(session);
		}
		return new ResponseEntity<List<SessionResponse>>(sessionResponses,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<SessionResponse> Update(@RequestBody SessionRequest sessionRequest,@PathVariable Long id){
		
		ModelMapper modelMapper =new ModelMapper();
		
		SessionDto sessionDto=modelMapper.map(sessionRequest, SessionDto.class);
		SessionDto ModificationSession=sessionService.ModifierSession(sessionDto, id);
		
		SessionResponse sessionResponse =modelMapper.map(ModificationSession, SessionResponse.class);
		
		return new ResponseEntity<SessionResponse>(sessionResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable long id) throws Exception{
		sessionService.SupperimerSession(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
