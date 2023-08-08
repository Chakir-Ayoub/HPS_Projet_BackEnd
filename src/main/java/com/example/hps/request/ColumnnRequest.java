package com.example.hps.request;

import java.util.List;


import lombok.Data;

@Data
public class ColumnnRequest {
	private String name;
	private BoardRequest board;
	private List<TaskRequest> tasks;
}
