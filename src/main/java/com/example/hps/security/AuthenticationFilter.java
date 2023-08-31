package com.example.hps.security;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.hps.SpringApplicationContext;
import com.example.hps.dto.UtilisateurDto;
import com.example.hps.request.UserLoginRequest;
import com.example.hps.service.UtilisateurService;
import com.example.hps.serviceImpl.UtilisateurImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	
	@Autowired
	UtilisateurImpl utilisateurImpl;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			
			UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String userName = ((User) auth.getPrincipal()).getUsername(); 
		       UtilisateurService utilisateurService =(UtilisateurService)SpringApplicationContext.getBean("utilisateurImpl");
		       
		       UtilisateurDto userDto=utilisateurService.getUser(userName);
		       
	        String token = Jwts.builder()
	                .setSubject(userName)
	                .claim("id", userDto.getIdutilisateur())
	                .claim("name", userDto.getNom_utilisateur()+" "+userDto.getPrenom_utilisateur())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
	                .compact();
	        

	       
	      //Récupérer les information dans l'Body  
	        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	        res.addHeader("user_id",String.valueOf(userDto.getIdutilisateur()));
	        res.getWriter().write("{\"token\":\""+token+"\",\"id\":\""+userDto.getIdutilisateur()+"\"}");
	    }  
}
