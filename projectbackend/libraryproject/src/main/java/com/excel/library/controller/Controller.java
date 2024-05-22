package com.excel.library.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.excel.library.dto.AdminLoginDto;
import com.excel.library.dto.BookDto;
import com.excel.library.dto.BookHistoryDto;
import com.excel.library.dto.UserDto;
import com.excel.library.entity.User;
import com.excel.library.repository.UserRepo;
import com.excel.library.response.SuccessResponse;
import com.excel.library.service.LibraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping(path="api/v1/library")
public class Controller {
	
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping(path = "/auser")
	public ResponseEntity<SuccessResponse<String>> postSaveUser(@RequestBody UserDto dto) {
		String userId = libraryService.saveUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).
				body(SuccessResponse.
				<String>builder().data(userId).message("User added").build());
	}
	
	
	@PostMapping(path = "/abook")
	public ResponseEntity<SuccessResponse<String>> postSaveBook(@RequestBody BookDto dto) {
		String userId = libraryService.saveBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED).
				body(SuccessResponse.
				<String>builder().data(userId).message("Book added").build()); 
	}
	
	@PostMapping(path = "/atransaction")
	public ResponseEntity<SuccessResponse<String>> saveTransactionHistories(@RequestBody BookHistoryDto dto) {
		String userId = libraryService.saveTransactionHistories(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).
				body(SuccessResponse.
				<String>builder().data(userId).message("transaction added").build());
	}
	
	@GetMapping(path = "/alluser")
	public ResponseEntity<SuccessResponse<List<UserDto>>> getAllUser() {
		List<UserDto> allUsers = libraryService.getAllUser();
		return ResponseEntity.status(HttpStatus.ACCEPTED).
				body(SuccessResponse.
				<List<UserDto>>builder().
				data(allUsers).isError(false).message("All users are fetched")
				.build());
	}
	
	@GetMapping(path = "/userbyid")
	public ResponseEntity<SuccessResponse<UserDto>> getUserById(@RequestBody UserDto dto) {
		UserDto user = libraryService.getUserById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).
				body(SuccessResponse.<UserDto>builder()
						.data(user).isError(false)
						.message("User bt Id fetched")
						.build());
	}
	
	
	@GetMapping(path = "/allbook")
	public ResponseEntity<SuccessResponse<List<BookDto>>> getAllBooks() {
		List<BookDto> allBooks = libraryService.getAllBooks();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<List<BookDto>>builder()
						.data(allBooks).isError(false)
						.message("All Books are fetched")
						.build());
	}
	
	
	@GetMapping(path = "/bookbyid")
	public ResponseEntity<SuccessResponse<BookDto>> getBookById(@RequestBody BookDto dto) {
			BookDto bookEntity = libraryService.getBookById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<BookDto>builder()
						.data(bookEntity).isError(false)
						.message("Book by id fetched")
						.build());
	}
	
	@GetMapping(path ="/alltransaction")
	public ResponseEntity<SuccessResponse<List<BookHistoryDto>>> getAllTransaction() {
		List<BookHistoryDto> allTransaction = libraryService.getAllTransaction();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<List<BookHistoryDto>>builder()
						.data(allTransaction).isError(false)
						.message("All tarnsaction are fetched")
						.build());
	}	
	
	@GetMapping(path = "/transactionbyid")
	public ResponseEntity<SuccessResponse<BookHistoryDto>> getTransactionById(@RequestBody BookHistoryDto dto) {
			BookHistoryDto transactionByID = libraryService.getTransactionById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<BookHistoryDto>builder()
						.data(transactionByID).isError(false)
						.message("transaction by id")
						.build());
						
	}
	
	@DeleteMapping(path = "/deleteuserbyid")
	public ResponseEntity<String> deletUserByID(@RequestBody UserDto dto) {
		libraryService.deletUserByID(dto);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted");
	}
	
	
	@DeleteMapping(path = "/deletebookbyid")
	public ResponseEntity<String> deletBookByID(@RequestBody BookDto dto) {
		libraryService.deletBookByID(dto);
		return ResponseEntity.status(HttpStatus.OK).body("Book deleted");
	}
	
	@PutMapping(path = "/updateuserbyid")
	ResponseEntity<SuccessResponse<String>> upadateUserById(@RequestBody UserDto dto){
		String updatedUser = libraryService.upadateUserById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.body(SuccessResponse.<String>builder()
									.data(updatedUser).message("User Updated")
									.build());
	}
	
	@PutMapping(path = "/updatebookbyid")
	ResponseEntity<SuccessResponse<String>> upadateBookById(@RequestBody BookDto dto){
		String updatedBook = libraryService.upadateBookById(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.body(SuccessResponse.<String>builder()
									.data(updatedBook).message("User Updated")
									.build());
	}
	
	
	
}
