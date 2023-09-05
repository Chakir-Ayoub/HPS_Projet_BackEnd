package com.example.hps.request;


import com.example.hps.entity.Columnn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TaskRequest {
	private String name;
	private ColumnnRequest columnn;
}
