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

import com.example.hps.dto.GroupeDto;
import com.example.hps.entity.Sous_Groupe;
import com.example.hps.entity.Utilisateur;
import com.example.hps.request.GroupeRequest;
import com.example.hps.response.GroupeResponse;
import com.example.hps.service.GroupeService;


@RestController
@RequestMapping("Groupe")
@CrossOrigin("http://localhost:4200")
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
	
	
	@GetMapping("/finduser/{id}")
	public ResponseEntity<GroupeResponse> GetById(@PathVariable Long id){
		GroupeDto groupeDto=groupeService.GetById(id);
		ModelMapper modelMapper=new ModelMapper();
		
		GroupeResponse groupeResponse =modelMapper.map(groupeDto, GroupeResponse.class);
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.OK);
	}
	
	@GetMapping("/{iduser}/{id}")
	public ResponseEntity<GroupeResponse> AffecteUserToGroupe(@PathVariable Long iduser, @PathVariable Long id ){
		
		ModelMapper modelMapper=new ModelMapper();

		GroupeDto groupeDto=groupeService.Affecte_Utilisateur_Groupe(iduser, id);
		GroupeResponse groupeResponse=modelMapper.map(groupeDto, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/RemoveUsertogroupe/{idgroup}/{iduser}")
	public ResponseEntity<GroupeResponse> RemoveUserInGroupe(@PathVariable Long idgroup,@PathVariable Long iduser) {
		
		ModelMapper modelMapper=new ModelMapper();
		
		GroupeDto groupeDto=groupeService.Supperimer_User_Groupe(idgroup, iduser);
		GroupeResponse groupeResponse=modelMapper.map(groupeDto, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/AfecteSous_Groupetogroupe/{id}")
	public ResponseEntity<GroupeResponse> AffecteSous_GroupToGroupe(@RequestBody Sous_Groupe sous_Groupe, @PathVariable Long id ){
		
		ModelMapper modelMapper=new ModelMapper();

		GroupeDto groupeDto=groupeService.Affecte_Sous_Group_Groupe(sous_Groupe, id);
		GroupeResponse groupeResponse=modelMapper.map(groupeDto, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/RemoveSoustogroupe/{idgroupe}/{idsousgroupe}")
	public ResponseEntity<GroupeResponse> RemoveSousGroupeInGroupe(@PathVariable Long idgroupe,@PathVariable Long idsousgroupe) {
		
		ModelMapper modelMapper=new ModelMapper();
		
		GroupeDto groupeDto=groupeService.Supperimer_Sous_groupe_Groupe(idgroupe, idsousgroupe);
		GroupeResponse groupeResponse=modelMapper.map(groupeDto, GroupeResponse.class);
		
		return new ResponseEntity<GroupeResponse>(groupeResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/UserCount/{id}")
	public ResponseEntity<Long> GetCountUserInGroupe(@PathVariable Long id){
	return new ResponseEntity<Long>(groupeService.GetCountUserInGroupe(id),HttpStatus.OK);	
	}

}
