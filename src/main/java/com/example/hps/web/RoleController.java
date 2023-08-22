package com.example.hps.web;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.RoleDto;
import com.example.hps.response.RoleResponse;
import com.example.hps.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleResponse> getroleByuser(@PathVariable Long id){
		
		RoleDto role=roleService.getrolebyuser(id);
		ModelMapper modelMapper=new ModelMapper();
		RoleResponse roleResponse=modelMapper.map(role, RoleResponse.class);
		
		return new ResponseEntity<RoleResponse>(roleResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<RoleResponse>> GetAll(){
		List<RoleDto> dtos=roleService.getAllRole();
		ModelMapper modelMapper=new ModelMapper();
		List<RoleResponse> responses=new ArrayList<>();
		for (RoleDto roleDto : dtos) {
			RoleResponse roleResponse=modelMapper.map(roleDto, RoleResponse.class);
			responses.add(roleResponse);
		}
		return new ResponseEntity<List<RoleResponse>>(responses,HttpStatus.ACCEPTED);
	}
}
