package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.RoleDto;
import com.example.hps.entity.Role;
import com.example.hps.repository.RoleRepository;
import com.example.hps.service.RoleService;

@Service
public class RoleImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	@Override
	public RoleDto getrolebyuser(Long iduser) {
		// TODO Auto-generated method stub
		Role role =roleRepository.getrolebyuser(iduser);
		if(role==null) throw new RestException("Ce user n'a aucun role");
		ModelMapper mapper=new ModelMapper();
		RoleDto roleDto=mapper.map(role, RoleDto.class);
		return roleDto;
	}
	@Override
	public List<RoleDto> getAllRole() {
		// TODO Auto-generated method stub
		List<Role> roles=roleRepository.findAll();
		List<RoleDto> dtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Role role : roles) {
			RoleDto roleDto= modelMapper.map(role, RoleDto.class);
			dtos.add(roleDto);
		}
		return dtos;
	}

}
