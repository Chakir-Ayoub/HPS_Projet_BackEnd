package com.example.hps.dto;

import java.util.List;

import com.example.hps.entity.Columnn;
import com.example.hps.entity.Projet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	private Long idboard;
	private String name;
	private List<Columnn> columns;
	private List<Projet> projet;

}
