package com.example.hps.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class DetailDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2072174640665542961L;
	private Long iddetail;
	private String Todo;
	private String Done;
	private String Doing;
	private String commentaire;
	private SessionDto session;
	private ProjetDto projet;
	private LocalDate dateCommentaire;
}
