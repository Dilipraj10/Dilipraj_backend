package com.excel.library.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BookHistory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer historyId;
	
	private LocalDate issuedDate;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	private boolean isReturned;
	
	private boolean isRenewed;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private User user;
	
	@JoinColumn(name = "book_id")
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Book book;
	

}
