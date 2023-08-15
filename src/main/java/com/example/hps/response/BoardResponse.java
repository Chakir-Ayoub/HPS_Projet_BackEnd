package com.example.hps.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
	private Long idboard;
	private String name;
	private List<ColumnnResponse> columns;
	private List<ProjetResponse> projet;

}
