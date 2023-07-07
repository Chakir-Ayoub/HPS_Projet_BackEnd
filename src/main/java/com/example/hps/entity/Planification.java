package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Planification implements Serializable {


	private static final long serialVersionUID = -2957808027729324688L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idPlanification;
	@Column(nullable = false)
	private LocalDate datePlanification;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "planification",orphanRemoval = true)
	private List<Session> sessions=new ArrayList<>();

	public Planification(Long idPlanification, LocalDate datePlanification, List<Session> sessions) {
		super();
		this.idPlanification = idPlanification;
		this.datePlanification = datePlanification;
		this.sessions = sessions;
	}

	public Planification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdPlanification() {
		return idPlanification;
	}

	public void setIdPlanification(Long idPlanification) {
		this.idPlanification = idPlanification;
	}

	public LocalDate getDatePlanification() {
		return datePlanification;
	}

	public void setDatePlanification(LocalDate datePlanification) {
		this.datePlanification = datePlanification;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
	
}
