package com.example.hps.request;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {
	private String name;
	private List<ColumnnRequest> columns;
	private List<ProjetRequest> projet;

}
