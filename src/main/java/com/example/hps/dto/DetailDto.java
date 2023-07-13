package com.example.hps.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DetailDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2072174640665542961L;
	private Long iddetail;
	private String Todo;
	private String Done;
	private String Doing;
	private String commentaire;
	private SessionDto session;
	private ProjetDto projet;
	private LocalDate dateCommentaire;

	public Long getIddetail() {
		return iddetail;
	}
	public LocalDate getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(LocalDate dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
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
	public SessionDto getSession() {
		return session;
	}
	public void setSession(SessionDto session) {
		this.session = session;
	}
	public ProjetDto getProjet() {
		return projet;
	}
	public void setProjet(ProjetDto projet) {
		this.projet = projet;
	}
	
	
	
	
}
