package com.example.hps.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Columnn implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -784887287736132657L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcolumn;
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "board")
	@JsonIgnore
	private Board board;
	
	@OneToMany(    cascade = CascadeType.ALL, mappedBy = "columnn")
	private List<Task> tasks=new ArrayList<>();
	
	@Transactional
	public void AjouterTask(Task task,Columnn columnn) {
		tasks.add(task);
		task.setColumnn(columnn);
	}

	
	@Transactional
	public void SupperimerTask(Task task) {
		Task taskSupprimer=null;
		
		for(Task t :tasks) {
			if(t.equals(task)) {
				taskSupprimer=t;
				break;
			}
		}
		if(taskSupprimer!=null) {
			tasks.remove(taskSupprimer);
		}
	}
	

	


}
