package com.example.hps.request;


import java.util.List;

import com.example.hps.entity.Sous_Groupe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupeRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@NotEmpty(message = "ce champs ne doit pas etre vide")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomgroupe;
	private List<Sous_Groupe> sous_Groupes;	
}
