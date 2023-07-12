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

import com.example.hps.dto.DetailDto;
import com.example.hps.request.DetailsRequest;
import com.example.hps.response.DetailResponse;
import com.example.hps.service.DetailsService;

@RestController
@RequestMapping("Detail")
public class DetailController {
	
	@Autowired
	DetailsService detailsService;
	
	@GetMapping
	public ResponseEntity<List<DetailResponse>> GetAll(){
		List<DetailResponse> detailResponses=new ArrayList<>();
		
		List<DetailDto> detailDtos=detailsService.GetAllDetail();
		
		for(DetailDto detailDto:detailDtos) {
			ModelMapper modelMapper=new ModelMapper();
			DetailResponse detailResponse=modelMapper.map(detailDto, DetailResponse.class);
			
			detailResponses.add(detailResponse);
		}
		return new ResponseEntity<List<DetailResponse>>(detailResponses,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<DetailResponse> Update(@RequestBody DetailsRequest detailsRequest,@PathVariable Long id){
		
		ModelMapper modelMapper=new ModelMapper();
		
		DetailDto detailDto=modelMapper.map(detailsRequest, DetailDto.class);
		DetailDto ModificationDetailDto=detailsService.ModifierDetail(detailDto, id);
		
		DetailResponse detailResponse=modelMapper.map(ModificationDetailDto, DetailResponse.class);
		
		
		return new ResponseEntity<DetailResponse>(detailResponse,HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<DetailResponse> Ajouter(@RequestBody DetailsRequest detailsRequest){
		ModelMapper modelMapper=new ModelMapper();
		DetailDto detailDto=modelMapper.map(detailsRequest, DetailDto.class);
		
		DetailDto createdetails=detailsService.AjouterDetail(detailDto);
		DetailResponse detailResponse=modelMapper.map(createdetails, DetailResponse.class);
		
		return new ResponseEntity<DetailResponse>(detailResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable Long id){
		
		detailsService.SupperimerDetail(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
