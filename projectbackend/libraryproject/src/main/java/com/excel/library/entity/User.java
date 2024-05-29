package com.excel.library.entity;

import java.util.List;

import org.hibernate.usertype.UserType;

import com.excel.library.enums.Gender;
import com.excel.library.enums.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private String userId;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String phoneNo;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String confirmPassword;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<BookHistory> histories;

}
