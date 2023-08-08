package com.example.hps.response;

import java.util.Date;

import lombok.Data;

@Data
public class ProjetResponse {
	private Long idprojet;
	private String nomprojet;
	private String description;
	private Date datedemarrage;
	private Boolean softdelete;
}
