package com.example.hps.request;

import java.util.List;

import com.example.hps.entity.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ColumnnRequest {
	private String name;
	private BoardRequest board;
	private List<TaskRequest> tasks;
}
