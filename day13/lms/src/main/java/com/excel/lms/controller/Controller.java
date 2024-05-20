package com.excel.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
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
	
	@PostMapping(path = "/sinfo")
	public ResponseEntity<SuccessResponse<String>>postSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto){
		String savedEmployee =	employeeService.saveSecondaryEmpInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.<String>builder().data(savedEmployee).isError(false).message("employee secondary info saved").build());
	}

	@PostMapping(path="/binfo")
	public ResponseEntity<SuccessResponse<Object>> postBankInfo(@RequestBody EmployeeBankDetailsDto dto){
		String savedDetails = employeeService.addBankDetails(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.builder().data(savedDetails).isError(false).message("employee bank info saved").build());
		
	}
	
	@PostMapping(path = "/cinfo")
	public ResponseEntity<SuccessResponse<String>> postContactInfo(@RequestBody EmployeeContactDto dto) {
	    String savedEmployeeId = employeeService.addContactDetails(dto);

	    if (savedEmployeeId != null) {
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(SuccessResponse.<String>builder()
	                        .data(savedEmployeeId)
	                        .isError(false)
	                        .message("Employee contact info saved")
	                        .build());
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(SuccessResponse.<String>builder()
	                        .data(null)
	                        .isError(true)
	                        .message("Failed to save employee contact info")
	                        .build());
	    }
	}

	
	
	

}
