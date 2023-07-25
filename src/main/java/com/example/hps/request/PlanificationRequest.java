package com.example.hps.request;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class PlanificationRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	private LocalDate datePlanification;
	private List<SessionRequest> sessions;
}
