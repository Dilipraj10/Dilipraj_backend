package com.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String name;
	private List<String> phones;
	private Set<String> skills;
	private Map<String,String> nominess;
	
//	public Employee() {
//		
//	}
//	
//	public Employee(String name, List<String> phones, Set<String> skills, Map<String, String> nominess) {
//		super();
//		this.name = name;
//		this.phones = phones;
//		this.skills = skills;
//		this.nominess = nominess;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public List<String> getPhones() {
//		return phones;
//	}
//	public void setPhones(List<String> phones) {
//		this.phones = phones;
//	}
//	public Set<String> getSkills() {
//		return skills;
//	}
//	public void setSkills(Set<String> skills) {
//		this.skills = skills;
//	}
//	public Map<String, String> getNominess() {
//		return nominess;
//	}
//	public void setNominess(Map<String, String> nominess) {
//		this.nominess = nominess;
//	}
	
	
}
