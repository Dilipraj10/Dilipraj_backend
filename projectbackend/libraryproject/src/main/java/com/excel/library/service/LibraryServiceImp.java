package com.excel.library.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.excel.library.dto.AdminDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.Admin;
import com.excel.library.entity.Book;
import com.excel.library.entity.BookHistory;
import com.excel.library.entity.Feedback;
import com.excel.library.entity.User;
import com.excel.library.enums.Genres;
import com.excel.library.exception.UserNotFoundException;
import com.excel.library.repository.AdminRepo;
import com.excel.library.repository.BookHistoryRepo;
import com.excel.library.repository.BookRepo;
import com.excel.library.repository.FeedbackRepo;
import com.excel.library.repository.UserRepo;
import com.excel.library.utils.Utils;

@Service
public class LibraryServiceImp implements LibraryService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private BookRepo bookRepository;

	@Autowired
	private BookHistoryRepo bookHistoryRepo;

	@Autowired
	private FeedbackRepo feedbackRepository;

	@Autowired
	private AdminRepo adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;

//Adding the user------------------------------------------------------------------------------------------	

//	@Override
//	public String saveUser(UserDto dto) {
//		if (!userRepository.findByEmail(dto.getEmail()).isPresent()) {
//			if (dto.getPassword().equals(dto.getConfirmPassword())) {
//				User user = Utils.userDtoToEntity(dto);
//				return userRepository.save(user).getUsername();
//			} else {
//				return "password mismatch!";
//			}
//		}
//		throw new UserNotFoundException("User already present");
//	}
	
	@Override
	public String saveUser(UserDto dto) {
		if (!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			if (dto.getPassword().equals(dto.getConfirmPassword())) {
				String password = encoder.encode(dto.getPassword());
				String confirmPassword = encoder.encode(dto.getConfirmPassword());
				User user = Utils.userDtoToEntity(dto,password,confirmPassword);
				return userRepository.save(user).getUsername();
			} else {
				return "password mismatch!";
			}
		}
		throw new UserNotFoundException("User already present");
	}

//Adding books------------------------------------------------------------------------------------------	
	@Override
	public String saveBook(BookDto dto) {
		if (!bookRepository.findByBookId(dto.getBookId()).isPresent()) {
			Book user = Utils.bookDtoToEntity(dto);
			return bookRepository.save(user).getBookId();

		}
		throw new UserNotFoundException("Book already present");
	}

//Adding transactions-------------------------------------------------------------------------------------------	
	@Override
	public String saveTransactionHistories(BookHistoryDto dto) {

		Optional<BookHistory> optional = bookHistoryRepo.findByBookBookIdAndUserEmail(dto.getBookId(), dto.getEmail());

		if (!optional.isPresent()) {

			Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());
			Optional<Book> bookOptional = bookRepository.findByBookId(dto.getBookId());

			if (userOptional.isPresent() && bookOptional.isPresent()) {
				User userEntity = userOptional.get();
				Book bookEntity = bookOptional.get();
				BookHistory bookHistoryEntity = Utils.transactionDtoToEntity(dto);

				if (userEntity.getHistories() != null) {
					if (userEntity.getHistories().contains(bookHistoryEntity)) {
						userEntity.getHistories().add(bookHistoryEntity);
					}
				} else {
					userEntity.setHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
				}

				if (bookEntity.getHistories() != null) {
					bookEntity.getHistories().contains(bookHistoryEntity);
					bookEntity.getHistories().add(bookHistoryEntity);
				}

				else {
					bookEntity.setHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
				}

				bookHistoryEntity.setUser(userEntity);
				bookHistoryEntity.setBook(bookEntity);

				return userRepository.save(userEntity).getUsername();
			}
		}
		
		else if(optional.isPresent()) {
			BookHistory history = optional.get();
			if(history.getIsReturned() == true) {
				history.setDueDate(dto.getDueDate());
				history.setIsRenewed(dto.getIsRenewed());
				history.setIsReturned(dto.getIsReturned());
				history.setIssuedDate(dto.getIssuedDate());
				history.setReturnDate(dto.getReturnDate());
				
				return bookHistoryRepo.save(history).getUser().getUsername();
			}
			
		}

		throw new UserNotFoundException("User already taken a book");
	}

//Fetching users---------------------------------------------------------------------------------------------------	
	@Override
	public List<UserDto> getAllUser(Integer userId, String name, String email) {
		try {
			List<UserDto> users = userRepository.findAll().stream()
					.map(e -> UserDto.builder().userId(e.getUserId()).username(e.getUsername()).email(e.getEmail())
							.phoneNo(e.getPhoneNo()).gender(e.getGender()).address(e.getAddress()).build())
					.toList();

			if (userId != null) {
				return users.stream().filter(u -> u.getUserId().equals(userId)).collect(Collectors.toList());
			} else if (name != null) {
				return users.stream().filter(u -> u.getUsername().equalsIgnoreCase(name)).collect(Collectors.toList());
			} else if (email != null) {
				return users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
			}
			return users;

		} catch (Exception e) {
			throw new UserNotFoundException("No users to show");
		}
	}

//Fetching books-------------------------------------------------------------------------------------------	
	@Override
	public List<BookDto> getAllBooks(String bookId, String bookName, String author, Genres genre) {
		try {
			List<BookDto> books = bookRepository.findAll().stream()
					.map(b -> BookDto.builder().bookId(b.getBookId()).bookUrl(b.getBookUrl()).bookName(b.getBookName())
							.bookAuthor(b.getBookAuthor()).genres(b.getGenres()).description(b.getDescription())
							.addedDate(b.getAddedDate()).totalCopies(b.getTotalCopies())
							.availableCopies(b.getAvailableCopies()).build())
					.toList();
			if (bookId != null) {
				return books.stream().filter(b -> b.getBookId().equalsIgnoreCase(bookId)).collect(Collectors.toList());
			} else if (bookName != null) {
				return books.stream().filter(b -> b.getBookName().equalsIgnoreCase(bookName))
						.collect(Collectors.toList());
			} else if (author != null) {
				return books.stream().filter(b -> b.getBookAuthor().equalsIgnoreCase(author))
						.collect(Collectors.toList());
			} else if (genre != null) {
				return books.stream().filter(b -> b.getGenres().equals(genre)).collect(Collectors.toList());
			}

			return books;
		} catch (Exception e) {
			throw new UserNotFoundException("No books to Show");
		}
	}


//Fetching the transactions-------------------------------------------------------------------------------------------	

	@Override
	public List<BookHistoryDto> getAllHistory(Integer historyId, String email, String bookId) {
		try {
			List<BookHistoryDto> history = bookHistoryRepo.findAll().stream()
					.map(t -> BookHistoryDto.builder().historyId(t.getHistoryId()).email(t.getUser().getEmail())
							.bookId(t.getBook().getBookId()).issuedDate(t.getIssuedDate()).dueDate(t.getDueDate())
							.returnDate(t.getReturnDate()).isReturned(t.getIsReturned()).isRenewed(t.getIsRenewed())
							.build())
					.toList();
			if (historyId != null) {
				return history.stream().filter(u -> u.getHistoryId().equals(historyId)).collect(Collectors.toList());
			}

			if (email != null) {
				return history.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
			}

			if (bookId != null) {
				return history.stream().filter(u -> u.getBookId().equalsIgnoreCase(bookId))
						.collect(Collectors.toList());
			}

			return history;
		} catch (Exception e) {
			throw new UserNotFoundException("No History to Show");
		}
	}

//Deleting the user-------------------------------------------------------------------------------------------	

	@Override
	public void deletUserByID(UserDto dto) {
		Optional<User> optional = userRepository.findByUserId(dto.getUserId());
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
		} else {
			throw new UserNotFoundException("No user to delete");
		}
	}

//Deleting the book-------------------------------------------------------------------------------------------	

	@Override
	public void deletBookByID(BookDto dto) {

		Optional<Book> optional = bookRepository.findByBookId(dto.getBookId());
		if (optional.isPresent()) {
			bookRepository.delete(optional.get());
		} else {
			throw new UserNotFoundException("No books to delete");
		}
	}

//Updating the user-------------------------------------------------------------------------------------------	

	@Override
	public String upadateUserByEmail(UserDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if (optional.isPresent()) {
			User userEntity = optional.get();
			userEntity.setUsername(dto.getUsername());
			userEntity.setAddress(dto.getAddress());
			userEntity.setEmail(dto.getEmail());
			userEntity.setGender(dto.getGender());
			userEntity.setPhoneNo(dto.getPhoneNo());
			return userRepository.save(userEntity).getUsername();
		}
		throw new UserNotFoundException("No user to update");
	}

//Updating the book-------------------------------------------------------------------------------------------	

	@Override
	public String upadateBookById(BookDto dto) {
		Optional<Book> optional = bookRepository.findByBookId(dto.getBookId());
		if (optional.isPresent()) {
			Book bookEntity = optional.get();
			bookEntity.setBookUrl(dto.getBookUrl());
			bookEntity.setBookName(dto.getBookName());
			bookEntity.setAddedDate(dto.getAddedDate());
			bookEntity.setAvailableCopies(dto.getAvailableCopies());
			bookEntity.setBookAuthor(dto.getBookAuthor());
			bookEntity.setDescription(dto.getDescription());
			bookEntity.setGenres(dto.getGenres());
			bookEntity.setTotalCopies(dto.getTotalCopies());

			return bookRepository.save(bookEntity).getBookId();
		}
		throw new UserNotFoundException("No book to update");
	}

//Adding the Feedback-------------------------------------------------------------------------------------------	

	@Override
	public String postFeedback(FeedbackDto dto) {
		Feedback feedback = Utils.feedbackDtoToEntiy(dto);
		return feedbackRepository.save(feedback).getName();
	}

//Adding admin------------------------------------------------------------------------------------------------	

	public String postAdmin(AdminDto dto) {
		Admin admin = Utils.adminDtoToEntity(dto);
		return adminRepository.save(admin).getAdminId();
	}

//Admin login--------------------------------------------------------------------------------------------------

	public String adminLogin(AdminDto dto) {
		Optional<Admin> optional = adminRepository.findByAdminId(dto.getAdminId());
		if (optional.isPresent()) {
			Admin admin = optional.get();
			if (admin.getPassword().equals(dto.getPassword()) && admin.getAdminId().equals(dto.getAdminId())) {
				return admin.getAdminId();
			} else {
				throw new UserNotFoundException("Invalid Password!");
			}
		}
		throw new UserNotFoundException("Invalid Username!");
	}

//User login------------------------------------------------------------------------------------	

//	@Override
//	public UserDto userLogin(UserDto dto) {
//		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
//		if (optional.isPresent()) {
//			User user = optional.get();
//			if (user.getEmail().equals(dto.getEmail()) && user.getPassword().equals(dto.getPassword())) {
//				return Utils.userLogin(user.getUsername(), user.getEmail());
//			} else {
//				throw new UserNotFoundException("Invalid Password!");
//			}
//		}
//		throw new UserNotFoundException("Invalid Email!");
//	}

	
	@Override
	public UserDto userLogin(UserDto dto) {
	    Optional<User> optional = userRepository.findByEmail(dto.getEmail());
	    if (optional.isPresent()) {
	        User user = optional.get();
	        if (encoder.matches(dto.getPassword(), user.getPassword())) {
	            return Utils.userLogin(user.getUsername(), user.getEmail());
	        } else {
	            throw new UserNotFoundException("Invalid Password!");
	        }
	    }
	    throw new UserNotFoundException("Invalid Email!");
	}
	
//Forgot password------------------------------------------------------------------------------------	
	@Override
	public String forgotPassword(UserDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if (optional.isPresent()) {
			User user = optional.get();
			user.setPassword(dto.getPassword());
			user.setConfirmPassword(dto.getConfirmPassword());
			return userRepository.save(user).getUsername();
		}
		throw new UserNotFoundException("Invalid Email!");
	}

//Fetch all the feedbacks------------------------------------------------------------------------------------	

	@Override
	public List<FeedbackDto> getAllFeedback() {
		return feedbackRepository.findAll().stream()
				.map(f -> FeedbackDto.builder().name(f.getName()).email(f.getEmail()).message(f.getMessage()).build())
				.toList();
	}

//Update transaction-------------------------------------------------------------------------------------------------	
	
	@Override
	public Integer updateTransaction(BookHistoryDto dto) {
		Optional<BookHistory> option = bookHistoryRepo.findByBookBookIdAndUserEmail(dto.getBookId(), dto.getEmail());
		if (option.isPresent()) {
			BookHistory history = option.get();
			history.setDueDate(dto.getDueDate());
			history.setIssuedDate(dto.getIssuedDate());
			history.setIsReturned(dto.getIsReturned());
			history.setIsRenewed(dto.getIsRenewed());
			history.setReturnDate(dto.getReturnDate());
			bookHistoryRepo.save(history);
			return history.getHistoryId();
		} else {
			throw new UserNotFoundException("User Or BookId Not Found!");
		}
	}

//Incrementing the available books count-------------------------------------------------------------------------------------------------	

	@Override
	public String incrementAvailableBook(BookDto dto) {
		Optional<Book> optional = bookRepository.findByBookId(dto.getBookId());
		if (optional.isPresent()) {
			Book book = optional.get();
			Integer count = book.getAvailableCopies();
			Integer available = count + 1;

			book.setAvailableCopies(available);
			Book save = bookRepository.save(book);
			return save.getBookId();
		}
		return null;
	}

//Decrementing available book count-------------------------------------------------------------------------------------------------	

	@Override
	public String decrementAvailableBook(BookDto dto) {
		Optional<Book> optional = bookRepository.findByBookId(dto.getBookId());
		if (optional.isPresent()) {
			Book book = optional.get();
			Integer count = book.getAvailableCopies();
			 if (count > 0) {
		            Integer available = count - 1;
		            book.setAvailableCopies(available);
		            bookRepository.save(book);
		            return book.getBookId();
		        } else {
		            throw new IllegalStateException("No available copies to decrement.");
		        }		
		}
		return null;
	}


//------------------------------------------------------------------------------------------------------	


}
