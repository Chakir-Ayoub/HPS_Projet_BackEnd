package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.TaskDto;

public interface TaskService {
	List<TaskDto> GetAll(String email);
	TaskDto GetById(Long id);
	TaskDto AddTask(TaskDto task,String email);
	TaskDto UpdateTask(Long id,TaskDto task);
	void RemoveTask(Long id);
	TaskDto AddTaskToColumn();
	List<TaskDto> GetColumnTask(Long idcolumn);
	Long GetCountTaskByUser(Long idcolumn,Long utilisateur);
}
