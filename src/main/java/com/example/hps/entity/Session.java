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
import jakarta.transaction.Transactional;
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
	@OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
	private List<Detail> details;
	
	@Transactional
	public void AddDetails(Detail detail,Session session ) {
		details.add(detail);
		detail.setSession(session);
	}



	
}
