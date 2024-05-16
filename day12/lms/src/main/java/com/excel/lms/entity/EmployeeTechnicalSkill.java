package com.excel.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class EmployeeTechnicalSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technicalSkill_id;
	
	private String skillType;
	private int skillRating;
	private int yearOfExperience;
	@Override
	public String toString() {
		return "EmployeeTechnicalSkill [skillType=" + skillType + ", skillRating=" + skillRating + ", yearOfExperience="
				+ yearOfExperience + "]";
	}

	
}
