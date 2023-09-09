package com.sukrit.bookmyshow.config;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sukrit.bookmyshow.exception.DuplicateRecordException;
import com.sukrit.bookmyshow.exception.ShowSeatNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.PropertyAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Log4j2
@RestControllerAdvice
public class ExceptionInterceptor {

	/************************ Framework Specific Exceptions ************************/


	@ExceptionHandler(PropertyAccessException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handlePropertyAccessException(PropertyAccessException e) {

		log.error("Got PropertyAccessException:", e);

		String errorMessgae = "Incorrect Value For Parameter: " + e.getPropertyName() + " in Request. Dirty Value: " + e.getValue();

		return new ResponseEntity<>(errorMessgae, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

		log.error("Got MethodArgumentTypeMismatchException: ", e);

		String errorMessage = "Incorrect Type For Parameter: " + e.getName() + " in Request. Expected: " + e.getRequiredType() + ", Found: " + e.getValue();

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {

		log.error("Got MissingServletRequestParameterException: ", e);

		String errorMessage = "Missing Parameter: " + e.getParameterName() + " in Request";

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleBindException(BindException e) {

		log.error("Got MissingServletRequestParameterException: ", e);

		BindingResult bindingResult = e.getBindingResult();

		StringBuilder fieldErrors = new StringBuilder();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			fieldErrors = fieldErrors.append("{FieldName: ").append(fieldError.getField()).append(", RejectedValue: ").append(fieldError.getRejectedValue()).append("} ");
		}

		String errorMessage = "Found: " + bindingResult.getErrorCount() + " Errors in Request. Fields With Error: [" + fieldErrors.toString() + "]";

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

		log.error("Got HttpMessageNotReadableException: ", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleInvalidFormatException(InvalidFormatException e) {

		log.error("Got InvalidFormatException: ", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {

		log.error("Got SQLIntegrityConstraintViolationException:", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

		log.error("Got ConstraintViolationException: ", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {

		log.error("Got DataIntegrityViolationException:", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/************************ Application Specific Exceptions ************************/

	@ExceptionHandler(DuplicateRecordException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleDuplicateRecordException(DuplicateRecordException e) {

		log.error("Got DuplicateRecordException: ", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ShowSeatNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleEntityNotFoundException(ShowSeatNotFoundException e) {

		log.error("Got EntityNotFoundException: ", e);

		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception ex) {

		log.error("Got un-handled exception: ", ex);

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}