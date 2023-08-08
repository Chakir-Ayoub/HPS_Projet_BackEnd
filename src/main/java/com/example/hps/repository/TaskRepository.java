package com.example.hps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hps.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	Task findByidtask(Long id);
	Task findByname(String nom);
	@Query(value = "SELECT * FROM `task` t WHERE t.columnn is null",nativeQuery = true)
	List<Task> GetTaskNull();
}
