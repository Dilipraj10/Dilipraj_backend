package com.excel.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.TechnicalSkillListDto;
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
	
	
	@PostMapping(path="/sinfo")
	public ResponseEntity<SuccessResponse<String>>postSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto) {
		String employeeId = employeeService.saveSecondaryInfo(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	
	@PostMapping(path = "/binfo")
	public  ResponseEntity<SuccessResponse<String>>postBankInfo(@RequestBody EmployeeBankDetailsDto dto) {
		
		String employeeId = employeeService.saveBankInfo(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	@PostMapping(path = "/einfo")
	public ResponseEntity<SuccessResponse<String>> postEducationInfo(@RequestBody EducationListDto dto) {
		String employeeId = employeeService.saveEducation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	@PostMapping(path = "/ainfo")
	public ResponseEntity<SuccessResponse<String>> postAddressInfo(@RequestBody AddressListDto dto) {
		String employeeId = employeeService.saveAddress(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	
	
	@PostMapping(path = "/cinfo")
	public ResponseEntity<SuccessResponse<String>> postContcatInfo(@RequestBody ContactListDto dto) {
		String employeeId = employeeService.saveContact(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	

	@PostMapping(path = "/exinfo")
	public ResponseEntity<SuccessResponse<String>> postExperienceInfo(@RequestBody ExperienceListDto dto) {
		String employeeId = employeeService.saveExperience(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	@PostMapping(path = "/tinfo")
	public ResponseEntity<SuccessResponse<String>> postSkillsInfo(@RequestBody TechnicalSkillListDto dto) {
		String employeeId = employeeService.saveSkills(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().
				data(employeeId).message("Employee Info Saved").build());
	}
	
	

}
