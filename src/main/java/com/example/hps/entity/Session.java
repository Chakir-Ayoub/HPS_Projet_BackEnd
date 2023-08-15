package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session implements Serializable {

	private static final long serialVersionUID = -8646960453346110640L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsession;
	@Column(length = 35,nullable = false)
	private String nomsession;
	@Column(nullable = false)
	private LocalTime heureD;
	@Column(nullable = false)
	private LocalTime heureF;
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "planification")
	private Planification planification;
	
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	
	@JsonIgnore
	@ManyToOne
	private Board board;


	
}
