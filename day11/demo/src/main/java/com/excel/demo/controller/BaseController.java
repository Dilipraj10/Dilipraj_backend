package com.excel.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.service.EmployeeService;

@RestController
public class BaseController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public ResponseEntity<String> homeGetReq() {
//		return "hello";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hello");
	}
	
	@PostMapping("/add") //giving path variable to home s so both will map that will comes in output
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto emp) {
		EmployeeDto dto = employeeService.addEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping("/delete/{id}") //giving path variable to home s so both will map that will comes in output
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		boolean deleted = employeeService.deleteEmployee(id);

		if (deleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Employee ID : " + id + " deleted successfully.");
		} 
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee ID : " + id + " not found.");
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> fetchAllEployee()
	{
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	
	

}
