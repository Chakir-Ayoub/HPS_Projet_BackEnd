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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.dto.BoardDto;
import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.SessionDto;
import com.example.hps.request.BoardRequest;
import com.example.hps.request.ColumnnRequest;
import com.example.hps.response.BoardResponse;
import com.example.hps.response.SessionResponse;
import com.example.hps.service.BoardService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("Board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public ResponseEntity<List<BoardResponse>> GetAll(Principal principal){
		ModelMapper modelMapper=new ModelMapper();
		List<BoardDto> boardDtos=boardService.GetAll(principal.getName());
		List<BoardResponse> boardResponses=new ArrayList<>();
		for (BoardDto boardDto : boardDtos) {
			BoardResponse boardResponse=modelMapper.map(boardDto, BoardResponse.class);
			boardResponses.add(boardResponse);
		}
		return new ResponseEntity<List<BoardResponse>>(boardResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BoardResponse> GetById(@PathVariable Long id,Principal principal){
		ModelMapper modelMapper=new ModelMapper();
		BoardDto boardDtos=boardService.GetById(id,principal.getName());
		BoardResponse boardResponse=modelMapper.map(boardDtos, BoardResponse.class);
		return new ResponseEntity<BoardResponse> (boardResponse,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BoardResponse> AddBoard(@RequestBody BoardRequest boardRequest,Principal principal){
		ModelMapper modelMapper=new ModelMapper();
		BoardDto boardDto=modelMapper.map(boardRequest, BoardDto.class);
		BoardDto boardDto2=boardService.AddBoard(boardDto,principal.getName());
		BoardResponse boardResponse=modelMapper.map(boardDto2, BoardResponse.class);
		
		return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BoardResponse> UpdateBoard(@PathVariable Long id,@RequestBody BoardRequest boardRequest){
		  ModelMapper modelMapper=new ModelMapper(); 
		  BoardDto boardDto=modelMapper.map(boardRequest, BoardDto.class); 
		  BoardDto boardDto2=boardService.UpdateBoard(id, boardDto);
		  
		  BoardResponse boardResponse=modelMapper.map(boardDto2, BoardResponse.class);
		 
		  return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> Remove(@PathVariable Long id,Principal principal){
		boardService.RemoveBoard(id,principal.getName());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("AffecteColumn/{idboard}")
	public ResponseEntity<BoardResponse> AddColumnToBoard(@PathVariable Long idboard,@RequestBody ColumnnRequest columnnRequest){
		ModelMapper modelMapper=new ModelMapper();
		ColumnnDto columnnDto=modelMapper.map(columnnRequest, ColumnnDto.class);
		BoardDto boardDto=boardService.AddColumnToBoard(idboard,columnnDto);
		
		BoardResponse boardResponse=modelMapper.map(boardDto, BoardResponse.class);
		
		return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("DeleteColumnFromBoard/{idColumn}/{idBoard}")
	public ResponseEntity<BoardResponse> SupperimerColumnn(@PathVariable Long idColumn,@PathVariable Long idBoard){
		
		BoardDto boardDto=boardService.RemoveColumnToBoard(idColumn, idBoard);
		ModelMapper modelMapper=new ModelMapper();
		
		BoardResponse boardResponse=modelMapper.map(boardDto, BoardResponse.class);
		
		return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("AffecteBoardTosession/{idboard}/{idsession}")
	public ResponseEntity<SessionResponse> AffecteBoardToSession(@PathVariable Long idboard,@PathVariable Long idsession){
		
		ModelMapper modelMapper=new ModelMapper();
		
		SessionDto sessionDto=boardService.AffectBoardToSession(idboard, idsession);
		
		SessionResponse sessionResponse=modelMapper.map(sessionDto, SessionResponse.class);
		
		return new ResponseEntity<SessionResponse>(sessionResponse,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "getboardbysession/{idsession}")
	public ResponseEntity<BoardResponse> GetBoardBySession(@PathVariable Long idsession,Principal principal){
		
		BoardDto boardDto=boardService.GetBoardBySession(idsession,principal.getName());
		ModelMapper modelMapper=new ModelMapper();
		
		BoardResponse boardResponse=modelMapper.map(boardDto, BoardResponse.class);
		
		return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.OK);
	}
	
	@GetMapping(path = "getboardbyuser/{idprojet}")
	public ResponseEntity<BoardResponse> GetBoardByProject(@PathVariable Long idprojet){
		BoardDto boardDto=boardService.GetBoardByProject(idprojet);
		ModelMapper modelMapper=new ModelMapper();
		
		BoardResponse boardResponse=modelMapper.map(boardDto, BoardResponse.class);
		return new ResponseEntity<BoardResponse>(boardResponse,HttpStatus.ACCEPTED);
	}
	
}
