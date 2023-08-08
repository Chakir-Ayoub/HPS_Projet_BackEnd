package com.example.hps.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import com.example.hps.entity.Utilisateur;

import lombok.Data;

@Data
public class SessionDto implements Serializable {

	private static final long serialVersionUID = -3315570845360016573L;
	
	private Long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	private PlanificationDto planification;
	private UtilisateurDto utilisateur;
	
}
