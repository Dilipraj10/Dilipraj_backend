package com.excel.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.response.SuccessResponse;
import com.excel.lms.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="api/v1/employee")
public class Controller {
	 
	@Autowired
	private EmployeeService employeeService;
	

	@PostMapping(path="/pinfo")
	public ResponseEntity<SuccessResponse<String>>postPrimaryInfo(@RequestBody EmployeePrimaryInfoDto dto) {
		String employeeId = employeeService.savePrimaryInfo(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	

}
