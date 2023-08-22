package com.example.hps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hps.repository.RoleRepository;
import com.example.hps.repository.UtilisateurRepository;



@SpringBootApplication
public class HpsAppApplication extends SpringBootServletInitializer   {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	RoleRepository roleRepository;
	
	protected SpringApplicationBuilder Configure(SpringApplicationBuilder application) {
		   return application.sources(HpsAppApplication.class);	
		}
	public static void main(String[] args) {
		SpringApplication.run(HpsAppApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

	/*@Bean
	CommandLineRunner SaveUsers() {
		return (args)->{
			roleRepository.save(new Role(null, "Admin", null));
			roleRepository.save(new Role(null, "Manager", null));
			roleRepository.save(new Role(null, "Emploi", null));
		};
	}*/

	
}