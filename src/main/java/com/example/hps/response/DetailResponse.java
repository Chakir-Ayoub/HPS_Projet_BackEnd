package com.example.hps.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DetailResponse {
	
	private Long iddetail;
	private String todo;
	private String done;
	private String doing;
	private String commentaire;
	private LocalDate dateCommentaire;
}
