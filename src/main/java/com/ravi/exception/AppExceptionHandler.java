package com.ravi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUNF(UserNotFoundException e) {
		String msg = e.getMessage();

		ErrorInfo info = new ErrorInfo();
		info.setExCode("SBCUD00123");
		info.setExDesc(msg);
		info.setExDate(LocalDateTime.now());

		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e) {

		String msg = e.getMessage();

		ErrorInfo info = new ErrorInfo();
		info.setExCode("SBCUD00123");
		info.setExDesc(msg);
		info.setExDate(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(info,HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
