package com.excel.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.excel.library.service.LibraryService;
import com.excel.library.service.LibraryServiceImp;

@SpringBootApplication
public class LibraryprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryprojectApplication.class, args);
	}

//	@Bean
//	LibraryService libraryService() {
//		return new LibraryServiceImp() {
//		};
//	}
}
