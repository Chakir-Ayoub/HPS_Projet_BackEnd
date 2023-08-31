package com.example.hps.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.Exceptions.RestException;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.response.GenericResponse;
import com.example.hps.service.UtilisateurService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class PasswordResetTokenRequest {
/*	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	UtilisateurService userService;*/
	
	/*@PostMapping("/user/resetPassword")
	public GenericResponse resetPassword(HttpServletRequest request, 
	  @RequestParam("email") String userEmail) {
	/*    Utilisateur user = utilisateurRepository.findByemail(userEmail);
	    if (user == null) {
	        throw new RestException("User Not Found");
	    }
	    String token = UUID.randomUUID().toString();
	    userService.createPasswordResetTokenForUser(user, token);
	    mailSender.send(constructResetTokenEmail(getAppUrl(request), 
	      request.getLocale(), token, user));
	    return new GenericResponse(
	      messages.getMessage("message.resetPasswordEmail", null, 
	      request.getLocale()));
	}*/
}
