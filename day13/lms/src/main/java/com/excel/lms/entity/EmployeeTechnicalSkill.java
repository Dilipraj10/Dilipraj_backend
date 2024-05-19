package com.excel.lms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employee_technical_skill")
public class EmployeeTechnicalSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technicalSkillId;
	
	private String skillType;
	private int skillRating;
	private int yearOfExperience;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EmployeePrimaryInfo> employees;
	
	
	@Override
	public String toString() {
		return "EmployeeTechnicalSkill [skillType=" + skillType + ", skillRating=" + skillRating + ", yearOfExperience="
				+ yearOfExperience + "]";
	}

	
}
