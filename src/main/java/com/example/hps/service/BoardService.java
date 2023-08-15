package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.BoardDto;
import com.example.hps.dto.ColumnnDto;
import com.example.hps.dto.SessionDto;

public interface BoardService {
	List<BoardDto> GetAll();
	BoardDto GetById(Long id);
	BoardDto AddBoard(BoardDto boardDto);
	BoardDto UpdateBoard(Long id,BoardDto boardDto);
	void RemoveBoard(Long id);
	BoardDto AddColumnToBoard(Long idBoard,ColumnnDto columnnDto);
	BoardDto RemoveColumnToBoard(Long idColumn,Long idBoard);
	SessionDto AffectBoardToSession(Long idboard,Long idSession);
	BoardDto GetBoardBySession(Long idsession);
}
