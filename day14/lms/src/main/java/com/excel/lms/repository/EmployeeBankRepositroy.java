package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeBankDetails;

public interface EmployeeBankRepositroy  extends JpaRepository<EmployeeBankDetails, Integer>{

	
}
