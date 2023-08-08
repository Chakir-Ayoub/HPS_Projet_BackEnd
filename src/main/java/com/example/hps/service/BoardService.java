package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.BoardDto;
import com.example.hps.dto.ColumnnDto;

public interface BoardService {
	List<BoardDto> GetAll();
	BoardDto GetById(Long id);
	BoardDto AddBoard(BoardDto boardDto);
	BoardDto UpdateBoard(Long id,BoardDto boardDto);
	void RemoveBoard(Long id);
	BoardDto AddColumnToBoard(Long idBoard,ColumnnDto columnnDto);
	BoardDto RemoveColumnToBoard(Long idColumn,Long idBoard);
}
