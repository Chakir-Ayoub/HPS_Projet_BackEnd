package com.example.hps.dto;

public class DetailDto {
	private Long iddetail;
	private String Todo;
	private String Done;
	private String Doing;
	private String commentaire;
	private SessionDto sessionDto;
	private ProjetDto projetDto;

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
	public SessionDto getSessionDto() {
		return sessionDto;
	}
	public void setSessionDto(SessionDto sessionDto) {
		this.sessionDto = sessionDto;
	}
	public ProjetDto getProjetDto() {
		return projetDto;
	}
	public void setProjetDto(ProjetDto projetDto) {
		this.projetDto = projetDto;
	}
	
	
}
