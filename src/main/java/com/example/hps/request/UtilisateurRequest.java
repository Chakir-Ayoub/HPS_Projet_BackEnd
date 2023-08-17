package com.example.hps.request;


import java.util.List;

import com.example.hps.entity.Groupe;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String nom_utilisateur;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String prenom_utilisateur;

	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Email(message = "Ce champs doit respecter la format email !")
	private String email;
	@Size(min = 8,message = "Ce champs doit avoir au moins 8 Caracteres !")
	@Size(max = 12,message = "Ce champs doit avoir au max 12 Caracteres !")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Ce chmps doit avoid des lettres en Maj et Minsc et Numero ")
	private String password;
	@Size(min = 10,message = "Ce champs doit avoir au moins 10 Caracteres !")
	@Size(max = 10,message = "Ce champs doit avoir au max 10 Caracteres !")
	private int telephone;

	
	private List<AbsenceRequest>  absences;
	
	private Groupe groupe;
	private List<SessionRequest> session;	
	private UtilisateurRequest utilisateur;
	private RoleRequest role;

}
