package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.TaskDto;

public interface ColumnnService {
	List<ColumnnDto> GetAll();
	ColumnnDto GetById(Long id);
	ColumnnDto AddColumnn(ColumnnDto columnnDto);
	ColumnnDto UpdateColumnn(Long id,ColumnnDto columnnDto);
	void RemoveColumnn(Long id);
	ColumnnDto AddTaskToColumn(Long idTask,TaskDto taskDto);
	ColumnnDto DeleteTaskFromColumn(Long IdTask,Long IdColumn);
	List<ColumnnDto> GetColumnByProject(Long id);
	Long getCountTask(Long id,String ame);
	void AddColumnToBoard(Long idboard,ColumnnDto columnnDto);
}
