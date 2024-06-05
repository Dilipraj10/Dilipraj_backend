package com.excel.library.dto;

import java.time.LocalDate;

import com.excel.library.enums.Genres;

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

public class BookDto {
	private String bookId; 
	private String bookUrl;
	private String bookName;
	private String bookAuthor;
	private Genres genres;
	private String description;
	private LocalDate addedDate;
	private int totalCopies;
	private int availableCopies;
}
