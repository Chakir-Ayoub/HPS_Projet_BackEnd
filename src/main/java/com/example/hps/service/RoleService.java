package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.RoleDto;

public interface RoleService {

	RoleDto getrolebyuser(Long iduser);
	List<RoleDto> getAllRole();
}
