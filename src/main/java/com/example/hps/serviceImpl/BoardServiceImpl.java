package com.example.hps.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.BoardDto;
import com.example.hps.dto.ColumnnDto;
import com.example.hps.entity.Board;
import com.example.hps.entity.Columnn;
import com.example.hps.entity.Task;
import com.example.hps.repository.BoardRepository;
import com.example.hps.repository.ColumnnRepository;
import com.example.hps.repository.TaskRepository;
import com.example.hps.service.BoardService;
@Service
public class BoardServiceImpl implements BoardService  {
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired 
	ColumnnRepository columnnRepository;
	@Autowired
	TaskRepository taskRepository;
	@Override
	public List<BoardDto> GetAll() {
		// TODO Auto-generated method stub
		List<Board> boards=boardRepository.findAll();
		List<BoardDto> boardDtos=new ArrayList<>();
		ModelMapper mapper=new ModelMapper();
		for (Board board : boards) {
			BoardDto boardDto=mapper.map(board,BoardDto.class);
			boardDtos.add(boardDto);
		}
		
		return boardDtos;
	}

	@Override
	public BoardDto GetById(Long id) {
		// TODO Auto-generated method stub
		Board board=boardRepository.findByidboard(id);
		if(board==null) throw new RestException("Cette Board n'existe Pas");
		ModelMapper mapper=new ModelMapper();
		BoardDto boardDto=mapper.map(board, BoardDto.class);
		return boardDto;
	}

	@Override
	public BoardDto AddBoard(BoardDto boardDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Board board=modelMapper.map(boardDto,Board.class);
		for(int i=0;i<boardDto.getColumns().size();i++) {
			board.AjouterColumns(board, boardDto.getColumns().get(i));
			for(int j=0;j<boardDto.getColumns().get(i).getTasks().size();j++) {
				board.getColumns().get(i).setTasks(boardDto.getColumns().get(i).getTasks());
				board.getColumns().get(i).getTasks().get(j).setColumnn(board.getColumns().get(i));
			}
		}
		
		for(int i=0;i<boardDto.getProjet().size();i++) {
			board.AjouterProjet(board, boardDto.getProjet().get(i));
			board.getProjet().get(i).setBoard(board);
		}
		Board board2=boardRepository.save(board);
		BoardDto boardDto2=modelMapper.map(board2, BoardDto.class);
		return boardDto2;
	}



	@Override
	public BoardDto UpdateBoard( Long id, BoardDto boardDto) {
		// TODO Auto-generated method stub
		Board board=boardRepository.findByidboard(id);
	//	RemoveBoard(id);
		if(board==null) throw new RestException("Cette Board n'existe Pas");
		ModelMapper modelMapper=new ModelMapper();		
		board.setName(boardDto.getName());
		Board board2=new Board();
			for(int i=0;i<boardDto.getColumns().size();i++) {
				for (Task t : boardDto.getColumns().get(i).getTasks() ) {
					if(boardDto.getColumns().get(i).getTasks().isEmpty() ) {
						Task task=taskRepository.findByidtask(board.getColumns().get(i).getTasks().get(i).getIdtask());
						board.getColumns().get(i).SupperimerTask(task);
					}
					else {
						List<Task> tasks=taskRepository.GetTaskNull();
						for(Task task:tasks) {
							taskRepository.delete(task);
						}
						Task task=taskRepository.findByname(t.getName());
							board.getColumns().get(i).setTasks(boardDto.getColumns().get(i).getTasks());
							task.setColumnn(board.getColumns().get(i));
							
					}
				}
			}
			 board2= boardRepository.save(board);
		BoardDto boardDto2=modelMapper.map(board2,BoardDto.class);
		return boardDto2;
	}
	
	@Override
	public void RemoveBoard(Long id) {
		// TODO Auto-generated method stub
		Board board=boardRepository.findByidboard(id);
		if(board==null) throw new RestException("Cette Board n'existe Pas");
		
		boardRepository.delete(board);

	}

	@Override
	public BoardDto AddColumnToBoard(Long idBoard, ColumnnDto columnnDto) {
		// TODO Auto-generated method stub
		Board board=boardRepository.findByidboard(idBoard);
		if(board==null) throw new RestException("Ce Board n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		Columnn columnn =modelMapper.map(columnnDto, Columnn.class);
		board.AjouterColumns(board, columnn);
		
		Board board2=  boardRepository.save(board);
		
		BoardDto boardDto=modelMapper.map(board2, BoardDto.class);
		return boardDto;
	}

	@Override
	public BoardDto RemoveColumnToBoard(Long idColumn,Long idBoard) {
		// TODO Auto-generated method stub
		Columnn columnn=columnnRepository.findByidcolumn(idColumn);
		Board board=boardRepository.findByidboard(idBoard);
		if(board==null) throw new RestException("Ce Board n'existe pas");
		if(columnn==null) throw new RestException("Ce Column n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		board.SupperimerColumns(columnn);
		
		Board board2= boardRepository.save(board);
		BoardDto boardDto=modelMapper.map(board2, BoardDto.class);
		
		return boardDto;
	}


}
