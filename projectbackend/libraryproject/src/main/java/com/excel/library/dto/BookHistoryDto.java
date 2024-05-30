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
	
	private int userId;
	
//	private String email;
	
	private String bookId;

	private LocalDate issuedDate;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	private boolean isReturned;
	
	private boolean isRenewed;

	
}
