package com.example.hps.request;



import com.example.hps.entity.Projet;
import com.example.hps.entity.Session;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DetailsRequest  {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Todo;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Done;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Doing;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String commentaire;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private Session session;
	private Projet projet;
	
}
