package com.example.hps.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ProjetResponse {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private LocalDate datelivraison;	
	private List<DetailResponse> details;
}
