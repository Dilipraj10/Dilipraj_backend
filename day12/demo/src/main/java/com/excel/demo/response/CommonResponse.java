package com.excel.demo.response;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CommonResponse<T> {
	
	private T data;
	private Boolean isError;
	private String message;

}
