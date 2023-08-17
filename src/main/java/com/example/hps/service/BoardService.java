package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.BoardDto;
import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.SessionDto;

public interface BoardService {
	List<BoardDto> GetAll(String email);
	BoardDto GetById(Long id,String email);
	BoardDto AddBoard(BoardDto boardDto,String email);
	BoardDto UpdateBoard(Long id,BoardDto boardDto);
	void RemoveBoard(Long id,String email);
	BoardDto AddColumnToBoard(Long idBoard,ColumnnDto columnnDto);
	BoardDto RemoveColumnToBoard(Long idColumn,Long idBoard);
	SessionDto AffectBoardToSession(Long idboard,Long idSession);
	BoardDto GetBoardBySession(Long idsession,String email);
}
