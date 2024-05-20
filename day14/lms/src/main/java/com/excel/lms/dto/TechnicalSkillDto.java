package com.excel.lms.dto;

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
public class TechnicalSkillDto {
private int technicalSkillId;
	
	private String skillType;
	private int skillRating;
	private int yearOfExperience;
}
