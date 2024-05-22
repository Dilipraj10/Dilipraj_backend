package com.excel.library.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.library.dto.AdminLoginDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.Book;
import com.excel.library.entity.BookHistory;
import com.excel.library.entity.User;
import com.excel.library.enums.Genres;
import com.excel.library.exception.UserNotFoundException;
import com.excel.library.repository.BookHistoryRepo;
import com.excel.library.repository.BookRepo;
import com.excel.library.repository.UserRepo;
import com.excel.library.utils.Utils;

@Service
public class LibraryServiceImp implements LibraryService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private BookHistoryRepo bookHistoryRepo;
	
	
	@Override
	public String saveUser(UserDto dto) {
		if(!userRepo.findByUserId(dto.getUserId()).isPresent())
		{
			User user =  Utils.userDtoToEntity(dto);
			return userRepo.save(user).getUserId();
			
		}
		throw new UserNotFoundException("User already present");
	}

	@Override
	public String saveBook(BookDto dto) {	
		if(!bookRepo.findByBookId(dto.getBookId()).isPresent())
		{
			Book user =  Utils.bookDtoToEntity(dto);
			return bookRepo.save(user).getBookId();
			
		}
		throw new UserNotFoundException("Book already present");
	}

	@Override
	public String saveTransactionHistories(BookHistoryDto dto) {
		
		Optional<User> userOptional = userRepo.findByUserId(dto.getUserId());
		Optional<Book> bookOptional = bookRepo.findByBookId(dto.getBookId());
		
		if(userOptional.isPresent() && bookOptional.isPresent())
		{
			User userEntity = userOptional.get();
			Book bookEntity = bookOptional.get();
			BookHistory bookHistoryEntity =  Utils.transactionDtoToEntity(dto);
			
			if(userEntity.getHistories() != null)
			{
				userEntity.getHistories().contains(bookHistoryEntity);
				userEntity.getHistories().add(bookHistoryEntity);
			}
			else {
				userEntity.setHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
			}
			
			if(bookEntity.getHistories() != null)
			{
				bookEntity.getHistories().contains(bookHistoryEntity);
				bookEntity.getHistories().add(bookHistoryEntity);
			}
			
			else {
				bookEntity.setHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
			}	
			
			bookHistoryEntity.setUser(userEntity);
			bookHistoryEntity.setBook(bookEntity);
			
			return userRepo.save(userEntity).getUserId();
 		}	
		throw new UserNotFoundException("User and Book Not found");
	}

	@Override
	public List<UserDto> getAllUser() {
		try {
			return userRepo.findAll().stream()
					.map(e -> UserDto.builder()
						.userId(e.getUserId())
						.username(e.getUsername())
						.email(e.getEmail())
						.phoneNo(e.getPhoneNo())
						.gender(e.getGender())
						.address(e.getAddress())
						.type(e.getType())
							.build()).toList();
		} catch (Exception e) {
			throw new UserNotFoundException("No users to show");
		}	 
	}

	@Override
	public UserDto getUserById(UserDto dto) {
		Optional<User> optional = userRepo.findByUserId(dto.getUserId());
		if(optional.isPresent()) {
			User userEntity = optional.get();
			return UserDto.builder()
					.userId(userEntity.getUserId())
					.username(userEntity.getUsername())
					.email(userEntity.getEmail())
					.phoneNo(userEntity.getPhoneNo())
					.gender(userEntity.getGender())
					.address(userEntity.getAddress())
					.type(userEntity.getType())
					.build();
		}
		throw new UserNotFoundException("No user to show");
	}

	@Override
	public List<BookDto> getAllBooks() {
		try {
			return bookRepo.findAll().stream().map(b -> BookDto.builder()
					.bookId(b.getBookId())
					.bookName(b.getBookName())
					.bookAuthor(b.getBookAuthor())
					.genres(b.getGenres())
					.description(b.getDescription())
					.addedDate(b.getAddedDate())
					.totalCopies(b.getTotalCopies())
					.availableCopies(b.getAvailableCopies())
					.build()).toList();
		} catch (Exception e) {
			throw new UserNotFoundException("No books to Show");
		}			 
	}

	@Override
	public BookDto getBookById(BookDto dto) {
		Optional<Book> optional = bookRepo.findByBookId(dto.getBookId());
		if(optional.isPresent())
		{
			Book book = optional.get();
			return BookDto.builder()
					.bookId(book.getBookId())
					.bookName(book.getBookName())
					.bookAuthor(book.getBookAuthor())
					.genres(book.getGenres())
					.description(book.getDescription())
					.addedDate(book.getAddedDate())
					.totalCopies(book.getTotalCopies())
					.availableCopies(book.getAvailableCopies())
					.build();
		}
		throw new UserNotFoundException("No books to show") ;
	}

	@Override
	public List<BookHistoryDto> getAllTransaction() {
		try {
			return bookHistoryRepo.findAll().stream()
					.map(t -> BookHistoryDto.builder()
							.historyId(t.getHistoryId())
							.bookId(t.getBook().getBookId())
							.userId(t.getUser().getUserId())
							.issuedDate(t.getIssuedDate())
							.dueDate(t.getDueDate())
							.returnDate(t.getReturnDate())
							.build()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new UserNotFoundException("No transaction to Show");
		}
	}

	@Override
	public BookHistoryDto getTransactionById(BookHistoryDto dto) {
		Optional<BookHistory> optional = bookHistoryRepo.findByHistoryId(dto.getHistoryId());
		if(optional.isPresent()) {
			BookHistory bookHistory = optional.get();
			return BookHistoryDto.builder()
					.historyId(bookHistory.getHistoryId())
					.userId(bookHistory.getUser().getUserId())
					.issuedDate(bookHistory.getIssuedDate())
					.returnDate(bookHistory.getReturnDate())
					.dueDate(bookHistory.getDueDate())
					.isRenewed(bookHistory.isRenewed())
					.isReturned(bookHistory.isReturned())
					.build();
		}
		
		throw new UserNotFoundException("No transaction to Show");
	}

	@Override
	public void deletUserByID(UserDto dto) {
			Optional<User> optional = userRepo.findByUserId(dto.getUserId());
			if(optional.isPresent()) {
				userRepo.delete(optional.get());
			}
			else {
			throw new UserNotFoundException("No user to delete");
		}
	}

	@Override
	public void deletBookByID(BookDto dto) {
		
			Optional<Book> optional = bookRepo.findByBookId(dto.getBookId());
			if(optional.isPresent()) {
				bookRepo.delete(optional.get());
			}
			else {
			throw new UserNotFoundException("No books to delete");
		}
	}

	@Override
	public String upadateUserById(UserDto dto) {
		Optional<User> optional = userRepo.findByUserId(dto.getUserId());
		if(optional.isPresent()) {
			User userEntity = optional.get();
			userEntity.setUsername(dto.getUsername());
			userEntity.setAddress(dto.getAddress());
			userEntity.setEmail(dto.getEmail());
			userEntity.setGender(dto.getGender());
			userEntity.setPhoneNo(dto.getPhoneNo());
			userEntity.setType(dto.getType());
			return userRepo.save(userEntity).getUserId();
		}
		throw new UserNotFoundException("No user to update");
	}

	@Override
	public String upadateBookById(BookDto dto) {
		Optional<Book> optional = bookRepo.findByBookId(dto.getBookId());
		if(optional.isPresent()) {
			Book bookEntity = optional.get();
			bookEntity.setBookName(dto.getBookName());
			bookEntity.setAddedDate(dto.getAddedDate());
			bookEntity.setAvailableCopies(dto.getAvailableCopies());
			bookEntity.setBookAuthor(dto.getBookAuthor());
			bookEntity.setDescription(dto.getDescription());
			bookEntity.setGenres(dto.getGenres());
			bookEntity.setTotalCopies(dto.getTotalCopies());
			
			return bookRepo.save(bookEntity).getBookId();	
		}
		throw new UserNotFoundException("No book to update");
	}

	
	
}


