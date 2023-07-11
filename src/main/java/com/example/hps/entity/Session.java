package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
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
	@JoinColumn(name = "id_planification")
	private Planification planification;
	
	@JsonIgnore
	@OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
	private List<Detail> details;

	public Session(Long idsession, String nomsession, LocalTime heureD, LocalTime heureF, Planification planification,
			List<Detail> details) {
		super();
		this.idsession = idsession;
		this.nomsession = nomsession;
		this.heureD = heureD;
		this.heureF = heureF;
		this.planification = planification;
		this.details = details;
	}

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdsession() {
		return idsession;
	}

	public void setIdsession(Long idsession) {
		this.idsession = idsession;
	}

	public String getNomsession() {
		return nomsession;
	}

	public void setNomsession(String nomsession) {
		this.nomsession = nomsession;
	}

	public LocalTime getHeureD() {
		return heureD;
	}

	public void setHeureD(LocalTime heureD) {
		this.heureD = heureD;
	}

	public LocalTime getHeureF() {
		return heureF;
	}

	public void setHeureF(LocalTime heureF) {
		this.heureF = heureF;
	}

	public Planification getPlanification() {
		return planification;
	}

	public void setPlanification(Planification planification) {
		this.planification = planification;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	
}
