package com.xm.opentrendsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class ControllerExceptionHndler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleBadRequest(EntityNotFoundException ex,HttpServletRequest request) {
		log.info("methods handleBadRequest"+ex.getMessage()+request);
		log.debug("methods handleBadRequest"+ex.getMessage()+request);
		 return new ResponseEntity("El request no es correcto/handleBadRequest ....", HttpStatus.NOT_FOUND);
	}
	

		
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
		log.info("methods handleException "+exception.getMessage()+request);
		log.debug("methods handleException "+exception.getMessage()+request);
		return new ResponseEntity("El request no es correcto ....", HttpStatus.BAD_REQUEST);
    }
	
}
