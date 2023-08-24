package com.example.hps.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
public class Projet implements Serializable {

	private static final long serialVersionUID = -6994354253010287858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprojet;
	@Column(nullable = false,length = 35)
	private String nomprojet;
	@Column(nullable = false,length = 35)
	private String description;
	@Column(nullable = false)
	private LocalDate datedemarrage;
	/*@Column(nullable = false)
	private LocalDate datelivraison;*/
	private Boolean softdelete;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "board")
	private Board board;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
	List<DatabaseFile> databaseFiles;
	
	@Transactional
	public void AddPin(DatabaseFile databaseFile,Projet projet) {
		databaseFiles.add(databaseFile);
		projet.setDatabaseFiles(databaseFiles);
	}
}
