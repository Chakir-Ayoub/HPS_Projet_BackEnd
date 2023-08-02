package com.example.hps.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;



@Data
public class ProjetDto {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private LocalDate datelivraison;
	private List<DetailDto> details;
	private Boolean softdelete;

}
