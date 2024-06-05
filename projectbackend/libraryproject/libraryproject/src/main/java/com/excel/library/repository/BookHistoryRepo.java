package com.excel.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.library.entity.BookHistory;

public interface BookHistoryRepo extends JpaRepository<BookHistory, Integer> {

	Optional<BookHistory> findByHistoryId(int historyId);

}
