package com.example.hps.request;

import java.util.Date;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomprojet;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String description;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Date datedemarrage;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Boolean softdelete;
	private BoardRequest board;



}
