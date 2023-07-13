package com.example.hps.response;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;


@Data
public class SessionResponse {
	
	private long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	private List<DetailResponse> details;
}
