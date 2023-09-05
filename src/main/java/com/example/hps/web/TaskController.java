package com.example.hps.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.TaskDto;
import com.example.hps.request.TaskRequest;
import com.example.hps.response.TaskResponse;
import com.example.hps.service.TaskService;

@RestController
@RequestMapping("Task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskResponse>> GetAll(Principal principal){
		
		List<TaskDto> taskDtos=taskService.GetAll(principal.getName());
		List<TaskResponse> taskResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (TaskDto taskDto : taskDtos) {
			TaskResponse taskResponse=modelMapper.map(taskDto, TaskResponse.class);
			taskResponses.add(taskResponse);
		}
		return new ResponseEntity<List<TaskResponse>>(taskResponses,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TaskResponse> GetByid(@PathVariable Long id){
		TaskDto taskDtos=taskService.GetById(id);
		
		ModelMapper  modelMapper=new ModelMapper();
		
		TaskResponse taskResponses=modelMapper.map(taskDtos, TaskResponse.class);
		return new ResponseEntity<TaskResponse>(taskResponses,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TaskResponse> AddTask(@RequestBody TaskRequest taskRequest,Principal principal){
		ModelMapper modelMapper=new ModelMapper();
		TaskDto taskDto=modelMapper.map(taskRequest, TaskDto.class);
		TaskDto taskDto2=taskService.AddTask(taskDto,principal.getName());
		
		TaskResponse taskResponse=modelMapper.map(taskDto2, TaskResponse.class);
		
		return new ResponseEntity<TaskResponse>(taskResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TaskResponse> UpdateTask(@PathVariable Long id ,@RequestBody TaskRequest taskRequest){
		ModelMapper modelMapper=new ModelMapper();
		TaskDto taskDto=modelMapper.map(taskRequest, TaskDto.class);
		
		TaskDto taskDto2=taskService.UpdateTask(id,taskDto);
		
		TaskResponse taskResponse=modelMapper.map(taskDto2, TaskResponse.class);
		
		return new ResponseEntity<TaskResponse>(taskResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> RemoveTask(@PathVariable Long id){
		
		taskService.RemoveTask(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("gettaskbycolumn/{idcolumn}")
	public ResponseEntity<List<TaskResponse>> GetTaskBYColumn(@PathVariable Long idcolumn){
		
		List<TaskDto> taskDtos=taskService.GetColumnTask(idcolumn);
		List<TaskResponse> taskResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (TaskDto taskDto : taskDtos) {
			TaskResponse taskResponse=modelMapper.map(taskDto, TaskResponse.class);
			taskResponses.add(taskResponse);
		}
		return new ResponseEntity<List<TaskResponse>>(taskResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getcountbyuser/{idcolumn}/{utilisateur}")
	public ResponseEntity<Long> GetCountTaskByUser(@PathVariable Long idcolumn,@PathVariable Long utilisateur) {
		
		Long counttaskbyuser=taskService.GetCountTaskByUser(idcolumn, utilisateur);
		
		return new ResponseEntity<Long>(counttaskbyuser,HttpStatus.ACCEPTED);
	}
}
