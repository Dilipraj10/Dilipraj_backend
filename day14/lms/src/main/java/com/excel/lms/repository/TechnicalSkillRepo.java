package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeTechnicalSkill;

public interface TechnicalSkillRepo extends JpaRepository<EmployeeTechnicalSkill, Integer> {

	Optional<EmployeeTechnicalSkill> findBySkillTypeAndSkillRatingAndYearOfExperience(String skillType ,int skillRating ,int yearOfExperience);
}
