package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.TaskDto;

public interface ColumnnService {
	List<ColumnnDto> GetAll(String email);
	ColumnnDto GetById(Long id,String email);
	ColumnnDto AddColumnn(ColumnnDto columnnDto,String email);
	ColumnnDto UpdateColumnn(Long id,ColumnnDto columnnDto,String email);
	void RemoveColumnn(Long id,String email);
	ColumnnDto AddTaskToColumn(Long idTask,TaskDto taskDto,String email);
	ColumnnDto DeleteTaskFromColumn(Long IdTask,Long IdColumn,String email);
	List<ColumnnDto> GetColumnByProject(Long id,String email);
	Long getCountTask(Long id,String ame);
	void AddColumnToBoard(Long idboard,ColumnnDto columnnDto,String email);
}
