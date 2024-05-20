package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeContact;

public interface ContactRepo  extends JpaRepository<EmployeeContact, Integer>{

}
