package com.example.hps.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class PlanificationDto {
	private Long idPlanification;
	private LocalDate datePlanification;
	private List<SessionDto> sessions;
}
