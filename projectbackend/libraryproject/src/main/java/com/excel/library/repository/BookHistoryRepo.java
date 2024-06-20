package com.excel.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.excel.library.entity.BookHistory;

import java.util.Optional;

public interface BookHistoryRepo extends JpaRepository<BookHistory, Integer> {

    Optional<BookHistory> findByHistoryId(Integer historyId);
    
	Optional<BookHistory> findByBookBookIdAndUserEmail(String bookId, String email);
}
