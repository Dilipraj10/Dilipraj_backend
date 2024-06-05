package com.excel.library.dto;

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
public class FeedbackDto {
	
	private Integer feedbackId;
	
	private String name;
	
	private String email;
	
	private String message;

}
