package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Detail implements Serializable {

	private static final long serialVersionUID = -3489310410191800962L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetail;
	@Column(nullable = false,length = 250)
	private String Todo;
	@Column(nullable = false,length = 250)
	private String Done;
	@Column(nullable = false,length = 250)
	private String Doing;
	@Column(nullable = false,length = 250)
	private String commentaire;
	private LocalDate dateCommentaire;
	
	@ManyToOne
	@JoinColumn(name = "id_session")
	private Session session;
	
	
	@ManyToOne
	@JoinColumn(name = "projet")
	private Projet projet;
}
