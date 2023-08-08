package com.example.hps.response;

import java.util.List;


import lombok.Data;

@Data
public class BoardResponse {
	private Long idboard;
	private String name;
	private List<ColumnnResponse> columns;
	private List<ProjetResponse> projet;

}
