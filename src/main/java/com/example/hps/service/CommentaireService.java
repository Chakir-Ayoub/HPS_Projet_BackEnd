package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.CommentaireDto;

public interface CommentaireService {
	CommentaireDto AddCommentaire(CommentaireDto commentaireDto);
	void DeleteCommentaire(Long id);
	List<CommentaireDto> getall();
	List<CommentaireDto> getAllCommentairebysession(Long idsession);
}
