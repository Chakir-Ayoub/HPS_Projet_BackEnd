package com.example.hps.response;

import java.time.LocalDate;
import java.util.List;

import com.example.hps.entity.DatabaseFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetResponse {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private LocalDate datedemarrage;
	private Boolean softdelete;
	private List<DatabaseFile> databaseFiles;

}
