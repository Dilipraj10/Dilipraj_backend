package com.excel.lms.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressListDto {

	private String employeeId;
	private List<EmployeeAddressDto> addresses;
	
}
