package com.excel.library.service;

import java.util.List;

import com.excel.library.dto.AdminDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;
import com.excel.library.dto.UserDto;
import com.excel.library.enums.Genres;

public interface LibraryService {

	public String saveUser(UserDto dto);

	public String saveBook(BookDto dto);

	public String saveTransactionHistories(BookHistoryDto dto);

	public List<UserDto> getAllUser(Integer userId, String name, String email);

	public List<BookDto> getAllBooks(String bookId, String bookName, String author, Genres genre);

	public void deletUserByID(UserDto dto);

	public void deletBookByID(BookDto dto);

	public String upadateUserByEmail(UserDto dto);

	public String upadateBookById(BookDto dto);

	public String postFeedback(FeedbackDto dto);

	public String postAdmin(AdminDto dto);

	public String adminLogin(AdminDto dto);

	public UserDto userLogin(UserDto dto);

	public String forgotPassword(UserDto dto);

	public List<BookHistoryDto> getAllHistory(Integer historyId, String email, String bookId);

	public List<FeedbackDto> getAllFeedback();

	public Integer updateTransaction(BookHistoryDto dto);

	public String incrementAvailableBook(BookDto dto);

	public String decrementAvailableBook(BookDto dto);

}
