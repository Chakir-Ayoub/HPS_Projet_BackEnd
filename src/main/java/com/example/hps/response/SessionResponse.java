package com.example.hps.response;

import java.time.LocalTime;

import com.example.hps.entity.Board;

import lombok.Data;


@Data
public class SessionResponse {
	
	private long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	private Board board;
}
