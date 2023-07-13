package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planification implements Serializable {


	private static final long serialVersionUID = -2957808027729324688L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idPlanification;
	@Column(nullable = false)
	private LocalDate datePlanification;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "planification",orphanRemoval = true)
	private List<Session> sessions;
	
	
	@Transactional
	public void AjouterSession(Session session,Planification planification) {
		sessions.add(session);
		session.setPlanification(planification);
	}
	@Transactional
	public void SupperimerSession(Session session) {
		Session sessionSupperimer=null;
		
		for(Session s : sessions) {
			if(s.equals(session)) {
				sessionSupperimer=s;
				break;
			}
		}
		if(sessionSupperimer !=null) {
			sessions.remove(sessionSupperimer);
		}
	}
}
