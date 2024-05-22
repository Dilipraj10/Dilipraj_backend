package com.excel.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.library.dto.UserDto;
import com.excel.library.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserId(String userId);

		
}
