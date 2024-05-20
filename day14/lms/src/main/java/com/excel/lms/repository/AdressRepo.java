package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeAddressDetails;

public interface AdressRepo extends JpaRepository<EmployeeAddressDetails, Integer> {

}
