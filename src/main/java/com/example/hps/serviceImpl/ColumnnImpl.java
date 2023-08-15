package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.TaskDto;
import com.example.hps.entity.Board;
import com.example.hps.entity.Columnn;
import com.example.hps.entity.Task;
import com.example.hps.repository.BoardRepository;
import com.example.hps.repository.ColumnnRepository;
import com.example.hps.repository.TaskRepository;
import com.example.hps.service.ColumnnService;

@Service
public class ColumnnImpl implements ColumnnService {
	
	@Autowired
	ColumnnRepository columnnRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	BoardRepository boardRepository;
	@Override
	public List<ColumnnDto> GetAll() {
		// TODO Auto-generated method stub
		List<Columnn> columnn=columnnRepository.findAll();
		List<ColumnnDto> columnnDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Columnn column : columnn) {
			ColumnnDto columnnDto=modelMapper.map(column, ColumnnDto.class);
			columnnDtos.add(columnnDto);
		}
		return columnnDtos;
	}

	@Override
	public ColumnnDto GetById(Long id) {
		// TODO Auto-generated method stub
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnn, ColumnnDto.class);
		return columnnDto;
	}

	@Override
	public ColumnnDto AddColumnn(ColumnnDto columnnDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Columnn columnn=modelMapper.map(columnnDto, Columnn.class);
		
		for(int i=0;i<columnnDto.getTasks().size();i++) {
			if(columnnDto.getTasks().size()==0) {
				break;
			}else {
				TaskDto taskDto=columnnDto.getTasks().get(i);
				taskDto.setColumnn(columnnDto);
				columnnDto.getTasks().set(i, taskDto);	
			}
		}
		
		Columnn columnn2=columnnRepository.save(columnn);
		
		ColumnnDto columnnDto2=modelMapper.map(columnn2,ColumnnDto.class);
		return columnnDto2;
	}

	@Override
	public ColumnnDto UpdateColumnn(Long id, ColumnnDto columnnDto) {
		// TODO Auto-generated method stub
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		columnn.setName(columnnDto.getName());
		Columnn columnn2=columnnRepository.save(columnn);
		
		ColumnnDto columnnDto2=modelMapper.map(columnn2, ColumnnDto.class);
		
		return columnnDto2;
	}

	@Override
	public void RemoveColumnn(Long id) {
		// TODO Auto-generated method stub
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas"); 
		
		columnnRepository.delete(columnn) ;
	}

	@Override
	public ColumnnDto AddTaskToColumn(Long idCol,TaskDto taskDto) {
		// TODO Auto-generated method stub
		Columnn columnn=columnnRepository.findByidcolumn(idCol);
		if(columnn==null) throw new RestException("Cette columnn n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		Task task=modelMapper.map(taskDto, Task.class);
		columnn.AjouterTask(task, columnn);
		
		Columnn columnn2=columnnRepository.save(columnn);
		
		ColumnnDto columnnDto2=modelMapper.map(columnn2, ColumnnDto.class);
		return columnnDto2;
	}

	@Override
	public ColumnnDto DeleteTaskFromColumn(Long IdTask, Long IdColumn) {
		// TODO Auto-generated method stub
		Task task=taskRepository.findByidtask(IdTask);
		if(task==null) throw new RestException("Cette Task n'existe pas");
		Columnn columnn=columnnRepository.findByidcolumn(IdColumn);
		if(columnn==null) throw new RestException("Ce Column n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		
		columnn.SupperimerTask(task);
		
	    Columnn columnn2=columnnRepository.save(columnn);
		ColumnnDto columnnDto2=modelMapper.map(columnn2, ColumnnDto.class);

		return columnnDto2;
	}

	@Override
	public List<ColumnnDto> GetColumnByProject(Long id) {
		// TODO Auto-generated method stub
		List<Columnn> columnn=columnnRepository.GetColumnByIdproject(id);
		if(columnn==null) throw new RestException("Cette Board est vide");
		
		List<ColumnnDto> columnnDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Columnn columnn2 : columnn) {
			ColumnnDto columnnDto=modelMapper.map(columnn2, ColumnnDto.class);
			columnnDtos.add(columnnDto);
		}
		return columnnDtos;
	}

	@Override
	public Long getCountTask(Long id, String name) {
		// TODO Auto-generated method stub
		
		Long num=columnnRepository.getcounttask(id, name);
		
		return num;
	}

	@Override
	public void AddColumnToBoard(Long idboard, ColumnnDto columnnDto) {
		// TODO Auto-generated method stub
		Board board=boardRepository.getboardbycolumn(idboard);
		ModelMapper modelMapper=new ModelMapper();
		if(board==null) throw new RestException("Cette Board n'existe pas");
		
		Columnn columnn=modelMapper.map(columnnDto, Columnn.class);
		board.AjouterColumns(board, columnn);
		
		boardRepository.save(board);
	}
	
	
	

}
