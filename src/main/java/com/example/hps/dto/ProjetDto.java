package com.example.hps.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;



@Data
public class ProjetDto {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private Boolean softdelete;
	private BoardDto board;


}
