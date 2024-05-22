package com.excel.library.service;

import java.util.List;

import com.excel.library.dto.AdminLoginDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.User;

public interface LibraryService {

	public String saveUser(UserDto dto);

	public String saveBook(BookDto dto);

	public String saveTransactionHistories(BookHistoryDto dto);

	public List<UserDto> getAllUser();

	public UserDto getUserById(UserDto dto);

	public List<BookDto> getAllBooks();

	public BookDto getBookById(BookDto dto);

	public List<BookHistoryDto> getAllTransaction();

	public BookHistoryDto getTransactionById(BookHistoryDto dto);

	public void deletUserByID(UserDto dto);

	public void deletBookByID(BookDto dto);

	public String upadateUserById(UserDto dto);

	public String upadateBookById(BookDto dto);

}
