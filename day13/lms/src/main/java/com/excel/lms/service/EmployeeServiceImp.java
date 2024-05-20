package com.excel.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeeContactDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.repository.EmployeePrimaryRepository;
import com.excel.lms.utils.Utils;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeePrimaryRepository EmployeeRepository;

	
	@Override
	public String savePrimaryInfo(EmployeePrimaryInfoDto dto) {
		if(!EmployeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1 = Utils.dtoToEntity(dto);
			EmployeePrimaryInfo employee = EmployeeRepository.save(employee1);
			return employee.getEmployeeId();
		}
		
		return null;
	}
	
	
	
	@Override
	public String saveSecondaryEmpInfo(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeePrimaryInfo> optional  = EmployeeRepository.findByEmployeeId(dto.getEmployeeId());
		
		if(optional.isPresent()) {
			  EmployeePrimaryInfo emp   = optional.get();
			  /*This if part is for saving*/
			  if(emp.getEmployeeSecondaryInfo() == null) {
				 EmployeeSecondaryInfo employeeSecondaryInfo = Utils.dtoToEntity(dto);				 
				 /*save to primaryEmployee*/
				 emp.setEmployeeSecondaryInfo(employeeSecondaryInfo);			 
				 /*again save to secondaryEmployee*/
				 employeeSecondaryInfo.setEmployeePrimaryInfo(emp);
				 /*here we save all data to PrimaryEmployee then get emp_id*/
				 return EmployeeRepository.save(emp).getEmployeeId();
			  }
			  /*This else part is only if we want to update any of field, it means not null */
			  else {
				  /*here we are getting from employeePrimaryInfo, if already data is stored*/
				 EmployeeSecondaryInfo secondaryInfo=  emp.getEmployeeSecondaryInfo();
				 /*here we are setting all fields*/
				 secondaryInfo.setPanNo(dto.getPanNo());
				 secondaryInfo.setAadharNo(dto.getAadharNo());
				 secondaryInfo.setFatherName(dto.getFatherName());
				 secondaryInfo.setMotherName(dto.getMotherName());
				 secondaryInfo.setMartialStatus(dto.getMartialStatus());
				 secondaryInfo.setPassportNo(dto.getPassportNo());
				 secondaryInfo.setSpouseName(dto.getSpouseName());
				 
				 return EmployeeRepository.save(emp).getEmployeeId();				 
			  }
		}	
		return null;
	}

	@Override
	public String addBankDetails(EmployeeBankDetailsDto dto) {
		
		Optional<EmployeePrimaryInfo> byEmployeeId = EmployeeRepository.findByEmployeeId(dto.getEmployeeId());
		
		if(byEmployeeId.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = byEmployeeId.get();
			/*this bank details comes from EmployeeprimaryDetails-->near instance of object(Bank)*/
			if(employeePrimaryInfo.getbankDetails() == null) {
				EmployeeBankDetails details = Utils.dtoToEntity(dto);
				
				employeePrimaryInfo.setBankDetails(details);
				
				details.setEmployeePrimaryInfo(employeePrimaryInfo);
				return EmployeeRepository.save(employeePrimaryInfo).getEmployeeId();
			}
			else {
				BankDetails bankDetails = employeePrimaryInfo.getBankDetails();

				bankDetails.setAccountNo(dto.getAccountNo());
				bankDetails.setBankName(dto.getBankName());
				bankDetails.setAccouontType(dto.getAccouontType());
				bankDetails.setIfscCode(dto.getIfscCode());
				bankDetails.setBranch(dto.getBranch());
				bankDetails.setState(dto.getState());

				return EmployeeRepository.save(employeePrimaryInfo).getEmployeeId();
			}
		}		
		return null;
	}



	@Override
	public String addContactDetails(EmployeeContactDto dto) {
	    Optional<EmployeePrimaryInfo> primaryInfoOptional = EmployeeRepository.findByEmployeeId(dto.getEmployeeId());

	    if (primaryInfoOptional.isPresent()) {
	        EmployeePrimaryInfo employeePrimaryInfo = primaryInfoOptional.get();

	        EmployeeContact employeeContact = new EmployeeContact();
	        employeeContact.setContactType(dto.getContactType());
	        employeeContact.setContactNo(dto.getContactNo());
	        employeeContact.setEmployee(employeePrimaryInfo);

	        if (employeePrimaryInfo.getContact() == null) {
	            employeePrimaryInfo.setContact(new ArrayList<>());
	        }

	        employeePrimaryInfo.getContact().add(employeeContact);

	        // Save the updated employee primary info
	        EmployeeRepository.save(employeePrimaryInfo);

	        return employeePrimaryInfo.getEmployeeId();
	    }

	    return null;
	}
	
}
