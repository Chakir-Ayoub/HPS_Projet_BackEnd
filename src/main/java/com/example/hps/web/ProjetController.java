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

import com.example.hps.dto.ProjetDto;
import com.example.hps.request.ProjetRequest;
import com.example.hps.response.ProjetResponse;
import com.example.hps.service.ProjetService;

@RestController
@RequestMapping("Project")
@CrossOrigin("http://localhost:4200")
public class ProjetController {
	
	@Autowired
	ProjetService projetService;
	
	@PostMapping
	public ResponseEntity<ProjetResponse> Ajouter(@RequestBody ProjetRequest projetRequest) throws Exception{
		ModelMapper modelMapper=new ModelMapper();
		ProjetDto projetDto=modelMapper.map(projetRequest, ProjetDto.class);
		
		ProjetDto createProjet=projetService.AjouterProjet(projetDto);
		ProjetResponse projetResponse=modelMapper.map(createProjet, ProjetResponse.class);
		
		return new ResponseEntity<ProjetResponse>(projetResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProjetResponse>> GetAllProject() throws Exception{
		List<ProjetResponse> projetResponses=new ArrayList<>();
		
		List<ProjetDto> projetDtos = projetService.GetAllProjet();
		
		for(ProjetDto projetDto: projetDtos) {
			ModelMapper modelMapper=new ModelMapper();
			ProjetResponse projet=modelMapper.map(projetDto, ProjetResponse.class);
			
			projetResponses.add(projet);
		}
		
		return new ResponseEntity<List<ProjetResponse>>(projetResponses,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ProjetResponse> Update(@RequestBody ProjetRequest projetRequest,@PathVariable Long id) throws Exception{
		
		ModelMapper modelMapper=new ModelMapper();
		
		ProjetDto projetDto= modelMapper.map(projetRequest, ProjetDto.class );
		ProjetDto ModificationprojetDto=projetService.ModifierProjet(projetDto, id);
		
		ProjetResponse projetResponse=modelMapper.map(ModificationprojetDto, ProjetResponse.class);
		
		
		return new ResponseEntity<ProjetResponse>(projetResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable long id) throws Exception{
		projetService.SupperimerProjet(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	

	
	@GetMapping("getByid/{id}")
	public ResponseEntity<ProjetResponse> GetByid(@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		ProjetDto projetDto=projetService.GetById(id);
		ProjetResponse projetResponse=modelMapper.map(projetDto,ProjetResponse.class);
		
		return new ResponseEntity<ProjetResponse>(projetResponse,HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/getcount")
	public ResponseEntity<Long> GetCountProject(){
		return new ResponseEntity<Long>(projetService.GetCountProject(),HttpStatus.OK);
	}
	
	@GetMapping("getstartproject")
	public ResponseEntity<Long> GetStartProject(){
		return new ResponseEntity<Long>(projetService.GetProjectStar(),HttpStatus.OK);
	}
	
	@GetMapping("getprojectbysession/{id}")
	public ResponseEntity<ProjetResponse> ProjetBySession(@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		ProjetDto projetDto=projetService.GetProjectBysesssion(id);
		
		ProjetResponse projetResponse=modelMapper.map(projetDto, ProjetResponse.class);
		
		return new ResponseEntity<ProjetResponse>(projetResponse,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/dropBydate")
	public void DropByDate(){
		projetService.DropProjectByDate();
	}

}
