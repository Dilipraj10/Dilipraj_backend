package com.excel.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.library.entity.Feedback;

public interface FeedbackRepo  extends JpaRepository<Feedback, Integer>{

}
