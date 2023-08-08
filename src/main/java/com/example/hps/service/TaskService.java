package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.TaskDto;

public interface TaskService {
	List<TaskDto> GetAll();
	TaskDto GetById(Long id);
	TaskDto AddTask(TaskDto task);
	TaskDto UpdateTask(Long id,TaskDto task);
	void RemoveTask(Long id);
	TaskDto AddTaskToColumn();
}
