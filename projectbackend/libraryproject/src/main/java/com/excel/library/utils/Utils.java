package com.excel.library.utils;

import java.time.LocalDate;

import com.excel.library.dto.AdminLoginDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.Book;
import com.excel.library.entity.BookHistory;
import com.excel.library.entity.User;

public class Utils {

	public static User userDtoToEntity(UserDto dto) {
		return User.builder()
				.userId(dto.getUserId()).username(dto.getUsername())
				.phoneNo(dto.getPhoneNo()).email(dto.getEmail())
				.gender(dto.getGender()).address(dto.getAddress()).type(dto.getType())
				.build();
	}

	public static Book bookDtoToEntity(BookDto dto) {
		return Book.builder()
				.bookId(dto.getBookId()).bookName(dto.getBookName())
				.bookAuthor(dto.getBookAuthor()).genres(dto.getGenres())
				.description(dto.getDescription())
				.addedDate(dto.getAddedDate())
				.availableCopies(dto.getAvailableCopies())
				.totalCopies(dto.getTotalCopies())
				.build();
	}

	public static BookHistory transactionDtoToEntity(BookHistoryDto dto) {
		return BookHistory.builder()
				.issuedDate(dto.getIssuedDate())
				.dueDate(dto.getDueDate())
				.returnDate(dto.getReturnDate())
				.isReturned(dto.isReturned())
				.isRenewed(dto.isRenewed())
				.build();
	}

	

	
	
}
