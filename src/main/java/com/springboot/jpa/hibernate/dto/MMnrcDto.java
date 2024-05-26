package com.springboot.jpa.hibernate.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class MMnrcDto {
	private Long id;
	private String mmId;
	private String name;
	private int age;
	private String gender;
	private String fatherName;
	private String motherName;
	private LocalDate issueDate;
	private LocalDate dateOfBirth;
	private String cityOfBirthPlace;
	private String stateAndDivision;
	private String addressId;
	private String occupation;
	private String bloodType;
	public MMnrcDto(Long id, String mmId, String name, int age, String gender, String fatherName, String motherName,
			LocalDate issueDate, LocalDate dateOfBirth, String cityOfBirthPlace, String stateAndDivision,
			String addressId, String occupation, String bloodType) {
		super();
		this.id = id;
		this.mmId = mmId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.issueDate = issueDate;
		this.dateOfBirth = dateOfBirth;
		this.cityOfBirthPlace = cityOfBirthPlace;
		this.stateAndDivision = stateAndDivision;
		this.addressId = addressId;
		this.occupation = occupation;
		this.bloodType = bloodType;
	}
	public MMnrcDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMmId() {
		return mmId;
	}
	public void setMmId(String mmId) {
		this.mmId = mmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCityOfBirthPlace() {
		return cityOfBirthPlace;
	}
	public void setCityOfBirthPlace(String cityOfBirthPlace) {
		this.cityOfBirthPlace = cityOfBirthPlace;
	}
	public String getStateAndDivision() {
		return stateAndDivision;
	}
	public void setStateAndDivision(String stateAndDivision) {
		this.stateAndDivision = stateAndDivision;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}  
	
	
}

