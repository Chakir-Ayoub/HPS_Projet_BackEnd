package com.example.hps.request;


import com.example.hps.entity.Groupe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Sous_groupeRequest {
	
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nomsousgroupe;
	private Groupe groupe;
}
