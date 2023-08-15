package com.example.hps.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnnRequest {
	private String name;
	private BoardRequest board;
	private List<TaskRequest> tasks;
}
