package com.excel.library.utils;

import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.Admin;
import com.excel.library.entity.Book;
import com.excel.library.entity.BookHistory;
import com.excel.library.entity.Feedback;
import com.excel.library.entity.User;

public class Utils {



	public static User userDtoToEntity(UserDto dto) {
		return User.builder()
				.username(dto.getUsername())
				.phoneNo(dto.getPhoneNo()).email(dto.getEmail())
				.gender(dto.getGender()).address(dto.getAddress())
				.password(dto.getPassword())
				.confirmPassword(dto.getConfirmPassword())
				.build();
	}

	public static Book bookDtoToEntity(BookDto dto) {
		return Book.builder()
				.bookId(dto.getBookId()).bookName(dto.getBookName())
				.bookUrl(dto.getBookUrl())
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

	public static Feedback feedbackDtoToEntiy(FeedbackDto dto) {
		return Feedback.builder()
				.name(dto.getName())
				.email(dto.getEmail())
				.message(dto.getMessage())
				.build();
	}

	public static Admin adminDtoToEntity(Admin dto) {
		return Admin.builder()
				.adminId(dto.getAdminId())
				.password(dto.getPassword())
				.build();
	}
		
}
