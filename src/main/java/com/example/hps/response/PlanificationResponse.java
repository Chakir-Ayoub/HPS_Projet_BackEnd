package com.example.hps.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class PlanificationResponse {
	private Long idPlanification;
	private LocalDate datePlanification;
	private List<SessionResponse> sessions;
}
