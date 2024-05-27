package com.excel.library.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.library.exception.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userExceptionHandler(RuntimeException exe)
	{
		return ResponseEntity.ok(exe.getMessage());
	}
}
