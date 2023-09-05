package com.example.hps.request;

import java.util.List;

import com.example.hps.entity.Columnn;

import lombok.Data;

@Data
public class BoardRequest {
	private String name;
	private List<ColumnnRequest> columns;
	private List<ProjetRequest> projet;
}
