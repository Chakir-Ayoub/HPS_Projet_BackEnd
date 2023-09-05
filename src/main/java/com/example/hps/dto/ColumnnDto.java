package com.example.hps.dto;

import java.util.List;

import com.example.hps.entity.Task;

import lombok.Data;

@Data
public class ColumnnDto {
	private Long idcolumn;
	private String name;
	private List<TaskDto> tasks;
}
