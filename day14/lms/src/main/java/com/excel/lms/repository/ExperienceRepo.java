package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeExperience;

public interface ExperienceRepo extends JpaRepository<EmployeeExperience, Integer> {

}
