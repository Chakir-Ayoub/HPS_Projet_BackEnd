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

import com.example.hps.dto.UtilisateurDto;
import com.example.hps.request.UtilisateurRequest;
import com.example.hps.response.UtilisateurResponse;
import com.example.hps.service.UtilisateurService;

@RestController
@RequestMapping("Utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;

	
	@PostMapping
	public ResponseEntity<UtilisateurResponse> AjouterUtilisateur(@RequestBody UtilisateurRequest utilisateurRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateurRequest, UtilisateurDto.class);
		
		UtilisateurDto utilisateurDto2=utilisateurService.AjouterUtilisateur(utilisateurDto);
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto2, UtilisateurResponse.class);
		
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<UtilisateurResponse>> GetAllUtilisateur(){
		List<UtilisateurResponse> utilisateurResponses=new ArrayList<>();
		
		List<UtilisateurDto> utilisateurDtos=utilisateurService.GetAllUser();
		
		for(UtilisateurDto utilisateurDto: utilisateurDtos) {
			ModelMapper modelMapper=new ModelMapper();
			UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
			
			utilisateurResponses.add(utilisateurResponse);
		}
		
		return new ResponseEntity<List<UtilisateurResponse>>(utilisateurResponses,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Supperimer(@PathVariable Long id){
		
		utilisateurService.SupperimerUtilisateur(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<UtilisateurResponse> Update(@RequestBody UtilisateurRequest  UtilisateurRequest,@PathVariable Long id){
		
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=modelMapper.map(UtilisateurRequest, UtilisateurDto.class);
		UtilisateurDto utilisateurDto2=utilisateurService.ModifierUtilisateur(utilisateurDto, id);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto2, UtilisateurResponse.class);
		
		
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("/AffecteAbenceToUser/{iduser}/{idabs}")
	public ResponseEntity<UtilisateurResponse> AffecteAbsenceToUtilisateur(@PathVariable Long iduser,@PathVariable Long idabs){
		
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=utilisateurService.AjouterAbsenceToUtilisateur(iduser, idabs);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/SupperimerAbenceToUser/{iduser}/{idabs}")
	public ResponseEntity<UtilisateurResponse> DeleteAbenceToUse(@PathVariable Long iduser,@PathVariable Long idabs){
		
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=utilisateurService.SupperimerAbsenceToUtilisateur(iduser, idabs);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UtilisateurResponse> GetById(@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=utilisateurService.GetById(id);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("absenceNonJ/{id}")
	public ResponseEntity<Long> GetAbsenceNonJ(@PathVariable Long id){
		return new ResponseEntity<Long>(utilisateurService.NombreAbsenceNonJustifier(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("absenceJ/{id}")
	public ResponseEntity<Long> GetAbsenceJ(@PathVariable Long id){
		return new ResponseEntity<Long>(utilisateurService.NombreAbsenceJustifier(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("GetCount")
	public ResponseEntity<Long> GetCountProject(){
		return new ResponseEntity<Long>(utilisateurService.GetCountUser(),HttpStatus.OK);
	}
	
	@GetMapping("GetCountAbsence")
	public ResponseEntity<Long> GeyCountAbsence(){
		return new ResponseEntity<Long>(utilisateurService.GetCountAbsence(),HttpStatus.OK);
	}
}
