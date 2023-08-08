package com.example.hps.entity;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7820559443325400157L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtask;
	private String name;
	
	@JsonIgnore
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "columnn")
	private Columnn columnn;
}

