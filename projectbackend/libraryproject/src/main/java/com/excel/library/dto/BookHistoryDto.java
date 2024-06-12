package com.excel.library.dto;

import java.time.LocalDate;

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
public class BookHistoryDto {
	
	private Integer historyId; 
		
	private String email;
	
	private Integer userId;
	
	private String bookId;

	private LocalDate issuedDate;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	private Boolean isReturned;
	
	private Boolean isRenewed;
	
}
