package com.excel.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.library.dto.AdminDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.FeedbackDto;
import com.excel.library.dto.UserDto;
import com.excel.library.enums.Genres;
import com.excel.library.response.SuccessResponse;
import com.excel.library.service.LibraryService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/library")
public class Controller {

	@Autowired
	private LibraryService libraryService;

//Adding user-------------------------------------------------------------------------------------------	
	@PostMapping(path = "/auser")
	public ResponseEntity<SuccessResponse<String>> postSaveUser(@RequestBody UserDto dto) {
		String user = libraryService.saveUser(dto);
		if (user == "User already present") {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(SuccessResponse.<String>builder().data(user).message("User already present").build());
		} else if (user == "password mismatch!") {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(SuccessResponse.<String>builder().data(user).message("password mismatch!").build());
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.<String>builder().data(user).message("Registerd Sucessfully").build());
	}

//Adding book-------------------------------------------------------------------------------------------

	@PostMapping(path = "/abook")
	public ResponseEntity<SuccessResponse<String>> postSaveBook(@RequestBody BookDto dto) {
		String userId = libraryService.saveBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.<String>builder().data(userId).message("Book added").build());
	}

//Adding transaction-------------------------------------------------------------------------------------------	
	@PostMapping(path = "/atransaction")
	public ResponseEntity<SuccessResponse<String>> saveTransactionHistories(@RequestBody BookHistoryDto dto) {
		String userId = libraryService.saveTransactionHistories(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(userId).message("transaction added").build());
	}

//Fetching users-------------------------------------------------------------------------------------------	
	@GetMapping(path = "/alluser")
	public ResponseEntity<SuccessResponse<List<UserDto>>> getAllUser(
			@RequestParam(name = "userId", required = false) Integer userId,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email) {
		List<UserDto> allUsers = libraryService.getAllUser(userId, name, email);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(SuccessResponse.<List<UserDto>>builder().data(allUsers)
				.isError(false).message("All users are fetched").build());
	}

//Fetching books-------------------------------------------------------------------------------------------	
	@GetMapping(path = "/allbook")
	public ResponseEntity<SuccessResponse<List<BookDto>>> getAllBooks(
			@RequestParam(name = "bookId", required = false) String bookId,
			@RequestParam(name = "bookName", required = false) String bookName,
			@RequestParam(name = "author", required = false) String author,
			@RequestParam(name = "genre", required = false) Genres genre) {
		List<BookDto> allBooks = libraryService.getAllBooks(bookId, bookName, author, genre);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(SuccessResponse.<List<BookDto>>builder().data(allBooks)
				.isError(false).message("All Books are fetched").build());
	}

//Fetching transactions-------------------------------------------------------------------------------------------	
	@GetMapping(path ="/alltransaction")
	public ResponseEntity<SuccessResponse<List<BookHistoryDto>>> getAllTransaction(
			@RequestParam(name = "historyId",required = false) Integer historyId, 
			@RequestParam(name = "email",required = false) String email,
			@RequestParam(name = "bookId",required = false) String bookId)
	{
		List<BookHistoryDto> allTransaction = libraryService.getAllHistory(historyId, email, bookId );
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<List<BookHistoryDto>>builder()
						.data(allTransaction).isError(false)
						.message("All tarnsaction are fetched")
						.build());
	}

//Deleting user-------------------------------------------------------------------------------------------	
	@DeleteMapping(path = "/deleteuserbyid")
	public ResponseEntity<String> deletUserByID(@RequestBody UserDto dto) {
		libraryService.deletUserByID(dto);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted");
	}
//Deleting book-------------------------------------------------------------------------------------------	

	@DeleteMapping(path = "/deletebookbyid")
	public ResponseEntity<String> deletBookByID(@RequestBody BookDto dto) {
		libraryService.deletBookByID(dto);
		return ResponseEntity.status(HttpStatus.OK).body("Book deleted");
	}

//Updating user-------------------------------------------------------------------------------------------	
	@PutMapping(path = "/updateuserbyid")
	public ResponseEntity<SuccessResponse<String>> upadateUserByEmail(@RequestBody UserDto dto) {
		String updatedUser = libraryService.upadateUserByEmail(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(updatedUser).message("User Updated").build());
	}

//Updating book-------------------------------------------------------------------------------------------	
	@PutMapping(path = "/updatebookbyid")
	public ResponseEntity<SuccessResponse<String>> upadateBookById(@RequestBody BookDto dto) {
		String updatedBook = libraryService.upadateBookById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(updatedBook).message("Book Updated").build());
	}

//Updating transactions------------------------------------------------------------------------------------	

	@PutMapping(path = "/updatetransaction")
	public ResponseEntity<SuccessResponse<Integer>> upadateTransaction(@RequestBody BookHistoryDto dto) {
		Integer update = libraryService.updateTransaction(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<Integer>builder().data(update).message("transaction updated").build());
	}

//Adding feedback-------------------------------------------------------------------------------------------	
	@PostMapping(path = "/postfeedback")
	ResponseEntity<SuccessResponse<String>> postFeedback(@RequestBody FeedbackDto dto) {
		String feedback = libraryService.postFeedback(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(feedback).message("feedback added").build());
	}

//Adding admin-------------------------------------------------------------------------------------------	
	@PostMapping(path = "/postadmin")
	public ResponseEntity<SuccessResponse<String>> postAdmin(@RequestBody AdminDto dto) {
		String admin = libraryService.postAdmin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(admin).message("admin added").build());
	}

//Admin login-------------------------------------------------------------------------------------------	
	@PostMapping("/adminlogin")
	ResponseEntity<SuccessResponse<String>> adminLogin(@RequestBody AdminDto dto) {
		String admin = libraryService.adminLogin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder().data(admin).message("Admin Logined Successfully!").build());
	}

//User login-------------------------------------------------------------------------------------------------	

	@PostMapping(path = "/userlogin")
	public ResponseEntity<SuccessResponse<UserDto>> userLogin(@RequestBody UserDto dto) {
		UserDto user = libraryService.userLogin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(SuccessResponse.<UserDto>builder().data(user)
				.isError(false).message("User Login Successfully!").build());
	}
//Forgot password-------------------------------------------------------------------------------------------	

	@PostMapping(path = "/forgotpassword")
	public ResponseEntity<SuccessResponse<String>> forgotPassword(@RequestBody UserDto dto) {
		String update = libraryService.forgotPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				SuccessResponse.<String>builder().data(update).isError(false).message("Password Updated").build());
	}

//Fetching feedbacks------------------------------------------------------------------------------------   

	@GetMapping("getallFeedback")
	public ResponseEntity<SuccessResponse<List<FeedbackDto>>> getallFeedback() {
		List<FeedbackDto> feedback = libraryService.getAllFeedback();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(SuccessResponse.<List<FeedbackDto>>builder()
				.data(feedback).isError(false).message("All Feedback fetched!").build());

	}

//Incrementing available books-----------------------------------------------------------------------------------------------------------------------------   

	@PutMapping(path ="available/book/increement")
	public ResponseEntity<SuccessResponse<String>> increementAvaialable(@RequestBody BookDto dto) {
		String bookId = libraryService.incrementAvailableBook(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder()
						.data(bookId)
						.message("Incremented")
						.build());
	}
	
//Decrement available books--------------------------------------------------------------------------------------------------	

	@PutMapping(path = "available/book/decrement")
	public ResponseEntity<SuccessResponse<String>> decrementAvailable(@RequestBody BookDto dto) {
		String bookId = libraryService.decrementAvailableBook(dto);
		return  ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<String>builder()
						.data(bookId)
						.message("Decremented")
						.build());
	}

//------------------------------------------------------------------------------------------------
	
}
