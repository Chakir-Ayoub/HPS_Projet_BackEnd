package com.example.hps.entity;

import java.io.Serializable;

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
@AllArgsConstructor
@NoArgsConstructor
public class Sous_Groupe implements Serializable {


	private static final long serialVersionUID = -2269499074835694171L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsousgroupe;
	@Column(nullable = false,length = 35)
	private String nomsousgroupe;
	
	@ManyToOne
	@JoinColumn(name = "groupe")
	private Groupe groupe;


}
