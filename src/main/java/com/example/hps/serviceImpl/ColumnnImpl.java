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
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.BoardRepository;
import com.example.hps.repository.ColumnnRepository;
import com.example.hps.repository.TaskRepository;
import com.example.hps.repository.UtilisateurRepository;
import com.example.hps.service.ColumnnService;

@Service
public class ColumnnImpl implements ColumnnService {
	
	@Autowired
	ColumnnRepository columnnRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public List<ColumnnDto> GetAll(String email) {
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		List<Columnn> columnn=new ArrayList<>();
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		// TODO Auto-generated method stub
			columnn=columnnRepository.findAll();
		}
		else {
			columnn=columnnRepository.getColumnByUser(currentuser.getIdutilisateur());
		}
		List<ColumnnDto> columnnDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		for (Columnn column : columnn) {
			ColumnnDto columnnDto=modelMapper.map(column, ColumnnDto.class);
			columnnDtos.add(columnnDto);
		}
		return columnnDtos;

			
	}

	@Override
	public ColumnnDto GetById(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnn, ColumnnDto.class);
		return columnnDto;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public ColumnnDto AddColumnn(ColumnnDto columnnDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
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
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public ColumnnDto UpdateColumnn(Long id, ColumnnDto columnnDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		columnn.setName(columnnDto.getName());
		Columnn columnn2=columnnRepository.save(columnn);
		
		ColumnnDto columnnDto2=modelMapper.map(columnn2, ColumnnDto.class);
		
		return columnnDto2;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public void RemoveColumnn(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Columnn columnn=columnnRepository.findByidcolumn(id);
		if(columnn==null) throw new RestException("Ce Column N'existe pas"); 
		
		columnnRepository.delete(columnn) ;}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public ColumnnDto AddTaskToColumn(Long idCol,TaskDto taskDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Columnn columnn=columnnRepository.findByidcolumn(idCol);
		if(columnn==null) throw new RestException("Cette columnn n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		Task task=modelMapper.map(taskDto, Task.class);
		columnn.AjouterTask(task, columnn);
		
		Columnn columnn2=columnnRepository.save(columnn);
		
		
		ColumnnDto columnnDto2=modelMapper.map(columnn2, ColumnnDto.class);
		return columnnDto2;
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public ColumnnDto DeleteTaskFromColumn(Long IdTask, Long IdColumn,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==8 ) {
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
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public List<ColumnnDto> GetColumnByProject(Long id,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
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
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}

	@Override
	public Long getCountTask(Long id, String name) {
		// TODO Auto-generated method stub
		
		Long num=columnnRepository.getcounttask(id, name);
		
		return num;
	}

	@Override
	public void AddColumnToBoard(Long idboard, ColumnnDto columnnDto,String email) {
		// TODO Auto-generated method stub
		Utilisateur currentuser=utilisateurRepository.findByemail(email);
		if(currentuser.getRole().getIdRole()==7 || currentuser.getRole().getIdRole()==8 ) {
		Board board=boardRepository.getboardbycolumn(idboard);
		ModelMapper modelMapper=new ModelMapper();
		if(board==null) throw new RestException("Cette Board n'existe pas");
		
		Columnn columnn=modelMapper.map(columnnDto, Columnn.class);
		board.AjouterColumns(board, columnn);
		
		boardRepository.save(board);
		}
		else {
			throw new RestException("Vous n'avez pas le droit d'exécuter cette requête");
		}
	}
	
	
	

}
