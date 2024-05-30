package com.excel.library.dto;

import com.excel.library.enums.Gender;
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
	
	private Integer userId;
	private String username;
	private String phoneNo;
	private String email;
	private String address;
	private String password;
	private String confirmPassword;
	private Gender gender;
}
