package com.example.hps.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.hps.entity.Commentaire;
import com.example.hps.entity.DatabaseFile;

import lombok.Data;



@Data
public class ProjetDto {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private Boolean softdelete;
	private BoardDto board;
	private List<DatabaseFile> databaseFiles;


}
