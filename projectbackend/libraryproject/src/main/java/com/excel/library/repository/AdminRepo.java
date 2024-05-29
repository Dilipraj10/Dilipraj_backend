package com.excel.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.library.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {
	
	Optional<Admin> findByAdminId(String adminId);

}
