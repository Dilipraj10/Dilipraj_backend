package com.excel.lms.response;

import lombok.Builder;

@Builder
public class SuccessResponse<T> {

	private T data;
	private String message;
	

}
