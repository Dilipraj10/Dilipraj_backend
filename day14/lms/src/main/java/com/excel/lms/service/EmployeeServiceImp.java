package com.excel.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.TechnicalSkillListDto;
import com.excel.lms.entity.EmployeeAddressDetails;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeeContact;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperience;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeTechnicalSkill;
import com.excel.lms.repository.AdressRepo;
import com.excel.lms.repository.ContactRepo;
import com.excel.lms.repository.EmployeeBankRepositroy;
import com.excel.lms.repository.EmployeeEducationRepository;
import com.excel.lms.repository.EmployeePrimaryRepository;
import com.excel.lms.repository.EmployeeSecondaryRepository;
import com.excel.lms.repository.ExperienceRepo;
import com.excel.lms.repository.TechnicalSkillRepo;
import com.excel.lms.utils.Utils;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeePrimaryRepository employeeRepository;

	@Autowired
	private EmployeeSecondaryRepository employeeSecondaryRepo;

	@Autowired
	private EmployeeBankRepositroy employeeBankRepo;

	@Autowired
	private EmployeeEducationRepository educationRepo;

	@Autowired
	private AdressRepo addressRepo;
	
	@Autowired
	private ContactRepo contactRepo;
	
	@Autowired
	private ExperienceRepo experiencRepo;
	
	@Autowired
	private TechnicalSkillRepo skillRepo;

	@Override
	public String savePrimaryInfo(EmployeePrimaryInfoDto dto) {
		if (!employeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1 = Utils.dtoToEntity(dto);
			EmployeePrimaryInfo employee = employeeRepository.save(employee1);
			return employee.getEmployeeId();
		}

		return null;
	}

	@Override
	public String saveSecondaryInfo(EmployeeSecondaryInfoDto sdto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(sdto.getEmployeeId());

		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			if (employee.getSecondaryInfo() == null) {
				EmployeeSecondaryInfo employeeSecondaryInfo = Utils.dtoToEntity(sdto);

				employee.setSecondaryInfo(employeeSecondaryInfo);
				employeeSecondaryInfo.setEmployee(employee);
				return employeeSecondaryRepo.save(employeeSecondaryInfo).getEmployee().getEmployeeId();
			} else {
				EmployeeSecondaryInfo secondaryInfo = employee.getSecondaryInfo();
				secondaryInfo.setPanNo(sdto.getPanNo());
				secondaryInfo.setAadharNo(sdto.getAadharNo());
				secondaryInfo.setFatherName(sdto.getFatherName());
				secondaryInfo.setMotherName(sdto.getMotherName());
				secondaryInfo.setMaritalStatus(sdto.getMaritalStatus());
				secondaryInfo.setPassportNo(sdto.getPassportNo());
				secondaryInfo.setSpouseName(sdto.getSpouseName());

				return employeeSecondaryRepo.save(secondaryInfo).getEmployee().getEmployeeId();
			}
		}
		return null;
	}

	@Override
	public String saveBankInfo(EmployeeBankDetailsDto dto) {
		Optional<EmployeePrimaryInfo> bankOptional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (bankOptional.isPresent()) {
			EmployeePrimaryInfo employee = bankOptional.get();
			if (employee.getBankDetails() == null) {
				EmployeeBankDetails employeeBankDetails = Utils.bankDtoToEntity(dto);
				employee.setBankDetails(employeeBankDetails);
				employeeBankDetails.setEmployee(employee);
				return employeeBankRepo.save(employeeBankDetails).getEmployee().getEmployeeId();
			} else {
				EmployeeBankDetails bank = employee.getBankDetails();
				bank.setAccountNo(dto.getAccountNo());
				bank.setAccountType(dto.getAccountType());
				bank.setBankId(dto.getBankId());
				bank.setBankName(dto.getBankName());
				bank.setBranch(dto.getBranch());
				bank.setIfscCode(dto.getIfscCode());
				bank.setState(dto.getState());

				return employeeBankRepo.save(bank).getEmployee().getEmployeeId();
			}
		}
		return null;
	}

	@Override
	public String saveEducation(EducationListDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<EmployeeEducationDetails> educations = Utils.educationDtoToEntity(dto.getEducations());
			if (employee.getEducation() != null) {
				employee.getEducation().stream().forEach(edu -> educationRepo.delete(edu));
			}

			educations.stream().forEach(x -> x.setEmployee(employee));
			employee.setEducation(educations);

			employeeRepository.save(employee);
			return dto.getEmployeeId();
		}

		return null;
	}

	@Override
	public String saveAddress(AddressListDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<EmployeeAddressDetails> addresses = Utils.addressDtoToEntity(dto.getAddresses());
			if (employee.getAddresses() != null) {
				employee.getAddresses().stream().forEach(addressRepo::delete);
			}
			
			addresses.stream().forEach(x -> x.setEmployee(employee));
			employee.setAddresses(addresses);
			employeeRepository.save(employee);
			return dto.getEmployeeId();

		}

		return null;
	}

	@Override
	public String saveContact(ContactListDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent())
		{
			EmployeePrimaryInfo employee = optional.get();
			List<EmployeeContact> contacts = Utils.contactDtoToEntity(dto.getContacts());
			if(employee.getContact() != null)
			{
				employee.getContact().stream().forEach(contactRepo::delete);
			}
			
			contacts.stream().forEach(x -> x.setEmployee(employee));
			employee.setContact(contacts);
			employeeRepository.save(employee);
			return dto.getEmployeeId();

		}
		return null;
	}

	@Override
	public String saveExperience(ExperienceListDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent())
		{
			EmployeePrimaryInfo employee = optional.get();
			List<EmployeeExperience> experience = Utils.experiencrDtoToEntity(dto.getExperiences());
			if(employee.getExperience() != null)
			{
				employee.getExperience().stream().forEach(experiencRepo::delete);
			}
			experience.stream().forEach(x -> x.setEmployee(employee));
			employee.setExperience(experience);
			employeeRepository.save(employee);
			return dto.getEmployeeId();

		}
		
		return null;
	}

	
	@Override
	public String saveSkills(TechnicalSkillListDto dto) {
		
			Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
			if(employeeOptional.isPresent())
			{
				EmployeePrimaryInfo employee = employeeOptional.get();
				List<EmployeeTechnicalSkill> skills = dto.getSkills().stream().map(skill ->
				{
					Optional<EmployeeTechnicalSkill> optional = skillRepo
							.findBySkillTypeAndSkillRatingAndYearOfExperience(skill.getSkillType(), skill.getSkillRating(), skill.getYearOfExperience());
					
					return optional.isPresent() ? optional.get() : Utils.dtoToTechnicalEntity(skill);			
				}).collect(Collectors.toList());

				if (employee.getSkill()!= null)
				{
					employee.getSkill().clear();
				}
				
				skills.stream().forEach(x -> {
					if(!x.getEmployees().contains(employee))
						x.getEmployees().add(employee);
				});
				
				employee.setSkill(skills);
				employeeRepository.save(employee);
				return employee.getEmployeeId();
			}
			
		return null;
	}
	
}
