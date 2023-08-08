package com.example.hps.response;

import java.util.List;
import lombok.Data;

@Data
public class ColumnnResponse {
	private Long idcolumn;
	private String name;
	private List<TaskResponse> tasks;
}
