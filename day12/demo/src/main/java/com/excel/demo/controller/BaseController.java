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

import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.response.CommonResponse;
import com.excel.demo.response.CommonResponse.CommonResponseBuilder;
import com.excel.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



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
	public ResponseEntity<CommonResponseBuilder<EmployeeDto>> addEmployee(@RequestBody EmployeeDto emp) {
		EmployeeDto dto = employeeService.addEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<EmployeeDto>builder().data(dto)
				.isError(false).message(EmployeeConstant.EMPLOYEE_ADDED_SUCCESSFULLY));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CommonResponse<EmployeeDto>> getEmployeeById(@PathVariable("id") int id){
		EmployeeDto dto = employeeService.getEmployeeById(id);
		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<EmployeeDto>builder().data(dto)
				.isError(false).message(EmployeeConstant.EMPLOYEE_GOT_SUCCESSFULLY).build());
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<CommonResponse<List<EmployeeDto>>> getAllEmploye()
	{
		List<EmployeeDto> dto = employeeService.getAllEmployee();
		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<EmployeeDto>>builder().data(dto)
				.isError(false).message(EmployeeConstant.ALL_EMPLOYEE_GOT_SUCCESSFULLY).build());
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
	
	@PutMapping("/update") //giving path variable to home s so both will map that will comes in output
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto) {
		EmployeeDto dto1  = employeeService.updateEmployee(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto1);
	}

	

}
