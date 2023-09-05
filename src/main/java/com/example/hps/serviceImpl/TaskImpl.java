package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.TaskDto;
import com.example.hps.entity.Task;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.TaskRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.TaskService;

@Service
public class TaskImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<TaskDto> GetAll(String email) {
		// TODO Auto-generated method stub
		List<Task> tasks=new ArrayList<>();
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
			tasks=taskRepository.findAll();
		}
		else {
			tasks=taskRepository.GetTaskByUser(currentuser.getIdutilisateur());
		}
		List<TaskDto> taskDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Task task : tasks) {
			TaskDto taskDto2=modelMapper.map(task, TaskDto.class);
			taskDtos.add(taskDto2);
		}
		return taskDtos;
	}

	@Override
	public TaskDto GetById(Long id) {

		// TODO Auto-generated method stub
		Task task=taskRepository.findByidtask(id);
		if(task==null) throw new RestException("Cette Task n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		
		TaskDto taskDto=modelMapper.map(task, TaskDto.class);
		
		return taskDto;

	}

	@Override
	public TaskDto AddTask(TaskDto task,String email) {
		
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==1 || currentuser.getRole().getIdRole()==2 ) {
		ModelMapper modelMapper=new ModelMapper();
		Task task2=modelMapper.map(task, Task.class);
		
		Task task3=taskRepository.save(task2);
		
		TaskDto taskDto=modelMapper.map(task3, TaskDto.class);
		return taskDto;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public TaskDto UpdateTask(Long id, TaskDto taskDto) {
		// TODO Auto-generated method stub
		Task task=taskRepository.findByidtask(id);
		ModelMapper modelMapper=new ModelMapper();
		if(task==null) throw new RestException("Cette Task n'existe pas");
		
		task.setName(taskDto.getName());
		
		Task task2Task=taskRepository.save(task);
		
		TaskDto task2=modelMapper.map(task2Task, TaskDto.class);
	
		return task2;
	}

	@Override
	public void RemoveTask(Long id) {
		// TODO Auto-generated method stub
		Task task=taskRepository.findByidtask(id);
		if(task==null) throw new RestException("Cette Task n'existe pas");
		
		taskRepository.delete(task);
	}

	@Override
	public TaskDto AddTaskToColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> GetColumnTask(Long idcolumn) {
		// TODO Auto-generated method stub
		List<Task> tasks=taskRepository.GetTaskByColumn(idcolumn);
		List<TaskDto> taskDtos=new ArrayList<>();
		ModelMapper mapper=new ModelMapper();
		
		for (Task task : tasks) {
			
			TaskDto taskDto=mapper.map(task, TaskDto.class);
			taskDtos.add(taskDto);
		}
		
		return taskDtos;
	}

	@Override
	public Long GetCountTaskByUser(Long idcolumn, Long utilisateur) {
		// TODO Auto-generated method stub
		Long CountTask=taskRepository.GetCountTaskByUser(idcolumn, utilisateur);
		return CountTask;
	}

}
