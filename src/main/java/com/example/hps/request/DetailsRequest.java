package com.example.hps.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class DetailsRequest  {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Todo;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Done;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String Doing;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 5,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String commentaire;
	private SessionRequest session;
	private ProjetRequest projet;
	
	
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
	
	public SessionRequest getSession() {
		return session;
	}
	public void setSession(SessionRequest session) {
		this.session = session;
	}
	public ProjetRequest getProjet() {
		return projet;
	}
	public void setProjet(ProjetRequest projet) {
		this.projet = projet;
	}

	
}
