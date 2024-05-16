package com.excel.demo.handlerexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.excel.demo.exception.EmployeeNotFoundException;

public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeExceptionHandler(RuntimeException exe)
	{
		return ResponseEntity.ok(exe.getMessage());
	}

}
