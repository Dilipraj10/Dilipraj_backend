package com.excel.library.listdto;

import java.util.List;

import com.excel.library.dto.BookDto;
import com.excel.library.entity.User;


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
public class BookListDto {

	private String userId;
	private List<BookDto> books;
	
	
}
