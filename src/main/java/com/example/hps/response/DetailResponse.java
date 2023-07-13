package com.example.hps.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DetailResponse {
	
	private Long iddetail;
	private String Todo;
	private String Done;
	private String Doing;
	private String commentaire;
	private LocalDate dateCommentaire;
}
