package com.example.hps.request;

import java.time.LocalDate;
import java.util.List;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjetRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomprojet;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String description;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datedemarrage;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datelivraison;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private List<DetailsRequest> details;
	private Boolean softdelete;


}
