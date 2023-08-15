package com.example.hps.web;

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

import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.TaskDto;
import com.example.hps.request.ColumnnRequest;
import com.example.hps.request.TaskRequest;
import com.example.hps.response.ColumnnResponse;
import com.example.hps.service.ColumnnService;

@RestController
@RequestMapping("Column")
public class ColumnnController {
	
	@Autowired
	ColumnnService columnnService;
	
	@GetMapping
	public ResponseEntity<List<ColumnnResponse>> GetAll(){
		
		List<ColumnnDto> columnns =columnnService.GetAll();
		List<ColumnnResponse> columnnResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (ColumnnDto columnnDto : columnns) {
			ColumnnResponse columnnResponse=modelMapper.map(columnnDto, ColumnnResponse.class);
			columnnResponses.add(columnnResponse);
		}
		
		return new ResponseEntity<List<ColumnnResponse>>(columnnResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ColumnnResponse> GetById(@PathVariable Long id){
		ColumnnDto columnnDto=columnnService.GetById(id);
		ModelMapper modelMapper=new ModelMapper();
		ColumnnResponse columnnResponse=modelMapper.map(columnnDto, ColumnnResponse.class);
		
		return new ResponseEntity<ColumnnResponse>(columnnResponse,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ColumnnResponse> AddColumn(@RequestBody ColumnnRequest columnnRequest){
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnnRequest, ColumnnDto.class);
		ColumnnDto columnnDto2=columnnService.AddColumnn(columnnDto);

		ColumnnResponse columnnResponse=modelMapper.map(columnnDto2, ColumnnResponse.class);
		
		return new ResponseEntity<ColumnnResponse>(columnnResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ColumnnResponse> UpdateColumn(@PathVariable Long id,@RequestBody ColumnnRequest columnnRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnnRequest, ColumnnDto.class);
		
		ColumnnDto columnnDto2=columnnService.UpdateColumnn(id, columnnDto);
		
		ColumnnResponse columnnResponse=modelMapper.map(columnnDto2, ColumnnResponse.class);
		
		return new ResponseEntity<ColumnnResponse>(columnnResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> Remove(@PathVariable Long id){
		
		columnnService.RemoveColumnn(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/AffecteTasktoColumn/{idcol}")
	public ResponseEntity<ColumnnResponse> AddTaskToColumn(@PathVariable Long idcol,@RequestBody TaskRequest taskRequest){
		
		ModelMapper modelMapper=new ModelMapper();
		TaskDto taskDto=modelMapper.map(taskRequest, TaskDto.class);
		ColumnnDto columnnObject=columnnService.AddTaskToColumn(idcol, taskDto);
		
		ColumnnResponse columnnResponse=modelMapper.map(columnnObject, ColumnnResponse.class);
		return new ResponseEntity<ColumnnResponse>(columnnResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/DeleteTask/{idTask}/{idCol}")
	public ResponseEntity<ColumnnResponse> RemoveTaskFromColumn(@PathVariable Long idTask,@PathVariable Long idCol){
		ColumnnDto columnnDto=columnnService.DeleteTaskFromColumn(idTask, idCol);
		ModelMapper modelMapper=new ModelMapper();
		
		ColumnnResponse columnnResponse=modelMapper.map(columnnDto, ColumnnResponse.class);
		return new ResponseEntity<ColumnnResponse>(columnnResponse,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("getcolumnbysession/{id}")
	public ResponseEntity<List<ColumnnResponse>> GetColumnByProject(@PathVariable Long id){
		ModelMapper modelMapper=new ModelMapper();
		List<ColumnnDto> columnnDtos=columnnService.GetColumnByProject(id);
		List<ColumnnResponse> columnnResponses=new ArrayList<>();
		for (ColumnnDto columnnDto : columnnDtos) {
			ColumnnResponse columnnResponse=modelMapper.map(columnnDto, ColumnnResponse.class);
			columnnResponses.add(columnnResponse);
		}
		return new ResponseEntity<List<ColumnnResponse>>(columnnResponses,HttpStatus.OK);
	}
	
	@GetMapping("getcounttask/{id}/{name}")
	public ResponseEntity<Long> GetCountTask(@PathVariable Long id,@PathVariable String name){
		Long count=columnnService.getCountTask(id, name);
		return new ResponseEntity<Long>(count,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("Addcolumntoboard/{id}")
	public ResponseEntity<Object> AddColumnToBoard(@PathVariable Long id,@RequestBody ColumnnRequest columnnRequest){
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnnRequest, ColumnnDto.class);
	
		columnnService.AddColumnToBoard(id, columnnDto);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}
