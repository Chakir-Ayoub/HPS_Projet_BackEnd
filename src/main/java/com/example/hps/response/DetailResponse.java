package com.example.hps.response;


public class DetailResponse {
	
	private Long iddetail;
	private String Todo;
	private String Done;
	private String Doing;
	private String commentaire;
	
	private SessionResponse sessionResponse ;
	private ProjetResponse projetResponse;
	
	
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
	public SessionResponse getSessionResponse() {
		return sessionResponse;
	}
	public void setSessionResponse(SessionResponse sessionResponse) {
		this.sessionResponse = sessionResponse;
	}
	public ProjetResponse getProjetResponse() {
		return projetResponse;
	}
	public void setProjetResponse(ProjetResponse projetResponse) {
		this.projetResponse = projetResponse;
	}
	
	
}
