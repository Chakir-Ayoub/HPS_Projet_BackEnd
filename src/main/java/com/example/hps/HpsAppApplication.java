package com.example.hps;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hps.entity.Detail;
import com.example.hps.entity.Projet;
import com.example.hps.entity.Session;
import com.example.hps.repository.DetailRepository;
import com.example.hps.repository.ProjetRepository;
import com.example.hps.repository.SessionRepository;

@SpringBootApplication
public class HpsAppApplication implements CommandLineRunner {
	
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private DetailRepository detailRepository;
	public static void main(String[] args) {
		SpringApplication.run(HpsAppApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LocalDate dateD = LocalDate.of(2023, 07, 06) ;
		LocalDate dateF = LocalDate.of(2023, 07, 16) ;
		
		LocalTime Time1=LocalTime.of(17, 44);
		LocalTime Time2=LocalTime.of(18, 44);
		
		Projet projet1=new Projet(null, "P1", "D1", dateD, dateF);
		projetRepository.save(projet1);
		projetRepository.save(new Projet(null, "P2", "D2", dateD, dateF));
		projetRepository.save(new Projet(null, "P4", "D4", dateD, dateF));
		projetRepository.save(new Projet(null, "P5", "D5", dateD, dateF));
		
		/*
		 * Session session1= new Session(0, "Session1", Time1, Time2);
		 * sessionRepository.save(session1); sessionRepository.save(new Session(0,
		 * "Session2", Time1, Time2)); sessionRepository.save(new Session(0, "Session3",
		 * Time1, Time2)); sessionRepository.save(new Session(0, "Session4", Time1,
		 * Time2));
		 */
		
		
		/*
		 * detailRepository.save(new Detail(null, "Todo1", "Done1", "Doing1",
		 * "Commentaire1", session1, projet1));
		 */		
		
		



		
	}

}
