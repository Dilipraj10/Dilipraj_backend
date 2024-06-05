package com.excel.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.library.entity.Book;

public interface BookRepo  extends JpaRepository<Book, Integer>{

	Optional<Book> findByBookId(String bookId);

}
