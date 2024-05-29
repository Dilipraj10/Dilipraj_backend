package com.excel.library.response;

import java.util.List;

import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponse<t> {

	private t data;
	
	private boolean isError;
	
	private String message;
}
