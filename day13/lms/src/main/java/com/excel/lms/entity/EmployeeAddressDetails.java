package com.excel.lms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class EmployeeAddressDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private String addressType;
	private String doorNo;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String pinCode;
	private String landMark;
	
	@JoinColumn(name = "employee_info")
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	private EmployeePrimaryInfo employeePrimaryInfo;
	
	
	@Override
	public String toString() {
		return "EmployeeAddressDetails [addressType=" + addressType + ", doorNo=" + doorNo + ", street=" + street
				+ ", locality=" + locality + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", landMark=" + landMark + "]";
	}
	
	

}
