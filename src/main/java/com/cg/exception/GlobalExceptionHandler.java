package com.cg.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.payload.ErrorInfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(GlobalExceptionHandler.class);

	@ExceptionHandler(DealerIdNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleDealerIdNotFoundException(DealerIdNotFoundException ex) {
		LOGGER.error(ex.getMessage(), ex);
		return "Dealer Id not found";
	}

	private static final org.jboss.logging.Logger LOGGER1 = LoggerFactory.logger(GlobalExceptionHandler.class);

	@ExceptionHandler(ContactNumberAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ResponseBody
	public String handleContactNumberAlreadyExistsException(ContactNumberAlreadyExistsException e) {
		LOGGER1.error(e.getMessage(), e);
		return "Dealer Already Exists";
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleProductNotExistingException(Exception e, HttpServletRequest req) {



	String uri = req.getRequestURI().toString();



	ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());



	ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	return responseEntity;
	}
}
