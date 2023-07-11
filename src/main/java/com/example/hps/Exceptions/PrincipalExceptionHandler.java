package com.example.hps.Exceptions;


import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PrincipalExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HttpStatus status2 = HttpStatus.BAD_REQUEST;

		Set<Map<String, Object>> errors = new HashSet<>();

		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();

		errorList.stream().forEach((fieldError) -> {
			Map<String, Object> error = new HashMap<>();
			error.put("source", fieldError.getField());
			error.put("message", fieldError.getDefaultMessage());
			errors.add(error);
		});

		RestErrorsExceptionResponse errorsResponse = new RestErrorsExceptionResponse(status2.name(), status2.value(),
				LocalDateTime.now(), "Erreur de validation", errors);
		return handleExceptionInternal(ex, errorsResponse, headers, status2, request);
	}

	@ExceptionHandler(RestException.class)
	public ResponseEntity<RestExceptionResponse> handleSecurityException(RestException se) {
		HttpStatus httpStatus = se.getHttpStatus();
		RestExceptionResponse response = new RestExceptionResponse(httpStatus.name(), httpStatus.value(),
				LocalDateTime.now(), se.getMessage());
		return new ResponseEntity<RestExceptionResponse>(response, httpStatus);
	}

	@ExceptionHandler(RestErrorsException.class)
	public ResponseEntity<RestErrorsExceptionResponse> handleSecurityErrorsException(RestErrorsException se) {
		HttpStatus httpStatus = se.getHttpStatus();
		RestErrorsExceptionResponse response = new RestErrorsExceptionResponse(httpStatus.name(), httpStatus.value(),
				LocalDateTime.now(), se.getMessage(), se.getErrors());
		return new ResponseEntity<RestErrorsExceptionResponse>(response, httpStatus);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<RestExceptionResponse> handleAccessDeniedException(AccessDeniedException se) {
		HttpStatus httpStatus = HttpStatus.FORBIDDEN;
		RestExceptionResponse response = new RestExceptionResponse(httpStatus.name(), httpStatus.value(),
				LocalDateTime.now(), se.getMessage());
		return new ResponseEntity<RestExceptionResponse>(response, httpStatus);
	}

}

