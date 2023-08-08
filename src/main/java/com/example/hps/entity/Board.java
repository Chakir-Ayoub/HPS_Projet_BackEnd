package com.example.hps.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Board implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4905646006659039036L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idboard;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "board")
	private List<Columnn> columns;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "board")
	private List<Projet> projet;
	
	
	@Transactional
	public void AjouterColumns(Board board,Columnn columnn) {
		columns.add(columnn);
		columnn.setBoard(board);
	}
	@Transactional
	public void SupperimerColumns(Columnn columnn) {
		Columnn columnnSupperimer=null;
		for(Columnn s :columns ) {
			if(s.equals(columnn)) {
				columnnSupperimer=s;
				break;
			}
		}
		if(columnnSupperimer!=null) {
			columns.remove(columnnSupperimer);
		}
	}
	
	@Transactional
	public void AjouterProjet(Board board,Projet projett) {
		projet.add(projett);
		projett.setBoard(board);
	}
}
