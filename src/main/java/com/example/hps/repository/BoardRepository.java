package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hps.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByidboard(Long id);
}
