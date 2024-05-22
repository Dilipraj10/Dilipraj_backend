package com.excel.library.dto;

import java.time.LocalDate;

import com.excel.library.enums.Gender;
import com.excel.library.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	
    private String userId;
	private String username;
	private String phoneNo;
	private String email;
	private Gender gender;
	private String address;
	private Type type;

}
