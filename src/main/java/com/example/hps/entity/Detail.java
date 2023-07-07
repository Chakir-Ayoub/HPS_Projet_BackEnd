package com.example.hps.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
	
	@ManyToOne
	@JoinColumn(name = "id_session")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name = "id_projet")
	private Projet projet;

	public Detail(Long iddetail, String todo, String done, String doing, String commentaire, Session session,
			Projet projet) {
		super();
		this.iddetail = iddetail;
		Todo = todo;
		Done = done;
		Doing = doing;
		this.commentaire = commentaire;
		this.session = session;
		this.projet = projet;
	}

	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIddetail() {
		return iddetail;
	}

	public void setIddetail(Long iddetail) {
		this.iddetail = iddetail;
	}

	public String getTodo() {
		return Todo;
	}

	public void setTodo(String todo) {
		Todo = todo;
	}

	public String getDone() {
		return Done;
	}

	public void setDone(String done) {
		Done = done;
	}

	public String getDoing() {
		return Doing;
	}

	public void setDoing(String doing) {
		Doing = doing;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	
}
