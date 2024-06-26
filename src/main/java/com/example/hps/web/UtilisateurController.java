package com.example.hps.web;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
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

import com.example.hps.dto.AbsenceDto;
import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Utilisateur;
import com.example.hps.request.AbsenceRequest;
import com.example.hps.request.UtilisateurRequest;
import com.example.hps.response.UtilisateurResponse;
import com.example.hps.service.UtilisateurService;

@RestController
@RequestMapping("Utilisateur")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;

	
	@PostMapping
	public ResponseEntity<UtilisateurResponse> AjouterUtilisateur(@RequestBody UtilisateurRequest utilisateurRequest) throws Exception{
		
		ModelMapper modelMapper=new ModelMapper();
		UtilisateurDto utilisateurDto=modelMapper.map(utilisateurRequest, UtilisateurDto.class);
		
		UtilisateurDto utilisateurDto2=utilisateurService.AjouterUtilisateur(utilisateurDto);
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto2, UtilisateurResponse.class);
		
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<UtilisateurResponse>> GetAllUtilisateur(Principal principal){
		List<UtilisateurResponse> utilisateurResponses=new ArrayList<>();
		
		List<UtilisateurDto> utilisateurDtos=utilisateurService.GetAllUser(principal.getName());
		
		for(UtilisateurDto utilisateurDto: utilisateurDtos) {
			ModelMapper modelMapper=new ModelMapper();
			UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
			
			utilisateurResponses.add(utilisateurResponse);
		}
		
		return new ResponseEntity<List<UtilisateurResponse>>(utilisateurResponses,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Supperimer(@PathVariable Long id,Principal principal){
		
		utilisateurService.SupperimerUtilisateur(id,principal.getName());
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<UtilisateurResponse> Update(@RequestBody UtilisateurRequest  UtilisateurRequest,@PathVariable Long id,Principal principal){
		
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=modelMapper.map(UtilisateurRequest, UtilisateurDto.class);
		UtilisateurDto utilisateurDto2=utilisateurService.ModifierUtilisateur(utilisateurDto, id,principal.getName());
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto2, UtilisateurResponse.class);
		
		
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.CREATED);
	}
	
	@PostMapping("/AffecteAbenceToUser/{iduser}")
	public ResponseEntity<UtilisateurResponse> AffecteAbsenceToUtilisateur(@PathVariable Long iduser,@RequestBody AbsenceRequest absenceRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		AbsenceDto absenceDto=modelMapper.map(absenceRequest, AbsenceDto.class);
		UtilisateurDto utilisateurDto=utilisateurService.AjouterAbsenceToUtilisateur(iduser, absenceDto);
		
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
	
	@GetMapping("GetUserwhereGroupIsNull")
	public ResponseEntity<List<UtilisateurResponse>> GetUserWhereGroupNull(){
		List<UtilisateurDto> utilisateurDtos=utilisateurService.GetUserWhereGroupeNull();
		List<UtilisateurResponse> utilisateurResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (UtilisateurDto utilisateurDto : utilisateurDtos) {
			UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
			utilisateurResponses.add(utilisateurResponse);
		}
		return new ResponseEntity<List<UtilisateurResponse>>(utilisateurResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("GetUserGroup/{id}")
	public ResponseEntity<List<UtilisateurResponse>> GetUser_Group(@PathVariable Long id){
		List<UtilisateurDto> utilisateurDtos=utilisateurService.GetUser_Group(id);
		List<UtilisateurResponse> utilisateurResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (UtilisateurDto utilisateurDto : utilisateurDtos) {
			UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
			utilisateurResponses.add(utilisateurResponse);
		}
		return new ResponseEntity<List<UtilisateurResponse>>(utilisateurResponses,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/AffecteSessionToUser/{iduser}/{idsesion}")
	public ResponseEntity<UtilisateurResponse> AffecteUtilisateurToSession(@PathVariable Long iduser,@PathVariable Long idsesion){
		ModelMapper modelMapper=new ModelMapper();
		UtilisateurDto utilisateurDto=utilisateurService.AjouterSessionToUtilisateur(iduser, idsesion);
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/SupperimerSessionToUse/{iduser}/{idsesion}")
	public ResponseEntity<UtilisateurResponse> DeleteSessionToUser(@PathVariable Long iduser,@PathVariable Long idsesion){
		ModelMapper  modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=utilisateurService.SupperimerSessionToUser(iduser, idsesion);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/userbysession/{id}")
	public ResponseEntity<UtilisateurResponse> GetUserBySession(@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		
		UtilisateurDto utilisateurDto=utilisateurService.GetUserBySession(id);
		
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.OK);
	}
	
	@GetMapping("userbyemail/{email}")
	public ResponseEntity<UtilisateurResponse> GetUserByemail(@PathVariable String email){
		/*UtilisateurDto utilisateurDto=utilisateurService.getUser(email);
		ModelMapper modelMapper=new ModelMapper();
		UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
		
		return new ResponseEntity<UtilisateurResponse>(utilisateurResponse,HttpStatus.ACCEPTED);*/
		return null;
	}
	
	@GetMapping("/getbyrole")
	public ResponseEntity< List<UtilisateurResponse> > GetUsersByRole(Principal principal){
		
		List<UtilisateurDto> utilisateurDtos=utilisateurService.getusersbyrole(principal.getName());
		List<UtilisateurResponse> utilisateurResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (UtilisateurDto utilisateurDto : utilisateurDtos) {
			UtilisateurResponse utilisateurResponse=modelMapper.map(utilisateurDto, UtilisateurResponse.class);
			utilisateurResponses.add(utilisateurResponse);
		}
		return new ResponseEntity<List<UtilisateurResponse>>(utilisateurResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getusersbyid")
	public ResponseEntity<List<Utilisateur>> GetIdUsers(){
		
		List<Utilisateur> get=utilisateurService.GetIdUsers();
		
		return new ResponseEntity<List<Utilisateur>>(get,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getusersbynom")
	public ResponseEntity<List<String>> GetnameUsers(){
		
		List<String> get=utilisateurService.GetnameUsers();
		
		return new ResponseEntity<List<String>>(get,HttpStatus.ACCEPTED);
	}
}
