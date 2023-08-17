package com.example.hps.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.hps.service.UtilisateurService;

@Configuration
public class WebSecurity extends AbstractHttpConfigurer<WebSecurity, HttpSecurity> {
	
	private final UtilisateurService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	 	

	    public WebSecurity(UtilisateurService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    	http
		    .cors().and()
		    .csrf().disable()
		    .authorizeRequests()
		    .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		    .permitAll() 
			.anyRequest().authenticated() 
			.and().addFilter(getAuthenticationFilter(authenticationManagerBuilder))
			.addFilter(new AuthorizationFilter(authenticationManagerBuilder.getObject()))
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        return http.build();
	    }
	    protected AuthenticationFilter getAuthenticationFilter(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManagerBuilder.getObject());
		    filter.setFilterProcessesUrl("/Utilisateur/login");
		    return filter;
		}

	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) 
	      throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	          .userDetailsService(userDetailsService)
	          .passwordEncoder(bCryptPasswordEncoder)
	          .and()
	          .build();
	    }

}
