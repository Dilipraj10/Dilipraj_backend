package com.excel.library.service;

import java.util.List;

import com.excel.library.dto.AdminDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.Admin;
import com.excel.library.enums.Genres;

public interface LibraryService {

	public String saveUser(UserDto dto);

	public String saveBook(BookDto dto);

	public String saveTransactionHistories(BookHistoryDto dto);

	public List<UserDto> getAllUser(Integer userId, String name, String email);

	public List<BookDto> getAllBooks(String bookId, String bookName, String author, Genres genre);

	public BookDto getBookById(BookDto dto);

	public BookHistoryDto getTransactionById(BookHistoryDto dto);

	public void deletUserByID(UserDto dto);

	public void deletBookByID(BookDto dto);

	public String upadateUserById(UserDto dto);

	public String upadateBookById(BookDto dto);

	public String postFeedback(FeedbackDto dto);

	public String postAdmin(Admin dto);

	public String adminLogin(AdminDto dto);

	public String userLogin(UserDto dto);

	public String forgotPassword(UserDto dto);

	public List<BookHistoryDto> getAllHistory(Integer historyId);

	public List<FeedbackDto> getAllFeedback();



}
