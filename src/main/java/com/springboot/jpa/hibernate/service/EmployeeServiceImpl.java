package com.springboot.jpa.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.jpa.hibernate.dto.EmployeeDto;
import com.springboot.jpa.hibernate.dto.MMnrcDto;
import com.springboot.jpa.hibernate.dto.ResponseDto;
import com.springboot.jpa.hibernate.model.BloodType;
import com.springboot.jpa.hibernate.model.CityOfBirthPlace;
import com.springboot.jpa.hibernate.model.Employee;
import com.springboot.jpa.hibernate.model.MMnrc;
import com.springboot.jpa.hibernate.model.StateAndDivision;
import com.springboot.jpa.hibernate.respository.IEmployeeRepository;
import com.springboot.jpa.hibernate.respository.INrcRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;
	private final INrcRepository nrcRepository;

	public EmployeeServiceImpl(IEmployeeRepository employeeRepository, INrcRepository nrcRepository) {
		this.employeeRepository = employeeRepository;
		this.nrcRepository = nrcRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

//	@Override
//	public Employee getEmployeeById(Long id) {
//
//		return employeeRepository.getReferenceById(id);
//	}

	@Override
	public String updateEmployee(Employee employee, Long id) {

		if (employeeRepository.existsById(id)) {
			employee.setId(id);
			employeeRepository.save(employee);
			return "id : " + employee.getId() + " is updated.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteEmployee(Long id) {

		if (employeeRepository.existsById(id)) {
			employeeRepository.delete(employeeRepository.getReferenceById(id));
			return id + " deleted.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteAllEmployees() {
		if (employeeRepository.count() > 0) {
			employeeRepository.deleteAll();
			return "All data deleted!";
		} else {
			return "Table is empty, no data is deleted. ";
		}

	}

	private EmployeeDto mapToEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setName(employee.getName());
		employeeDto.setDepartment(employee.getDepartment());
		employeeDto.setRole(employee.getRole());
		employeeDto.setMmnrcId(employee.getId());
		return employeeDto;
	}

	public Employee mapToEmployeeFromDto(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		// employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setRole(employeeDto.getRole());

		return employee;
	}

	public MMnrc dtoToMmNrc(MMnrcDto mmNrcDto) {
		MMnrc mmNrc = new MMnrc();
		// mmNrc.setId(mmNrcDto.getId()); // Assuming id is not mandatory
		mmNrc.setMmId(mmNrcDto.getMmId());
		mmNrc.setName(mmNrcDto.getName());
		mmNrc.setAge(mmNrcDto.getAge());
		mmNrc.setGender(mmNrcDto.getGender());
		mmNrc.setFatherName(mmNrcDto.getFatherName());
		mmNrc.setMotherName(mmNrcDto.getMotherName());
		mmNrc.setIssueDate(mmNrcDto.getIssueDate());
		mmNrc.setDateOfBirth(mmNrcDto.getDateOfBirth());

		if (mmNrcDto.getCityOfBirthPlace() != null) {
			try {
				mmNrc.setCityOfBirthPlace(CityOfBirthPlace.valueOf(mmNrcDto.getCityOfBirthPlace()));
			} catch (IllegalArgumentException e) {
				// Handle invalid city name (e.g., log warning or throw custom exception)
				System.out.println("WARNING: Invalid CityOfBirthPlace value: " + mmNrcDto.getCityOfBirthPlace());
			}
		}

		if (mmNrcDto.getStateAndDivision() != null) {
			try {
				mmNrc.setStateAndDivision(StateAndDivision.valueOf(mmNrcDto.getStateAndDivision()));
			} catch (IllegalArgumentException e) {
				// Handle invalid state/division name (e.g., log warning or throw custom
				// exception)
				System.out.println("WARNING: Invalid StateAndDivision value: " + mmNrcDto.getStateAndDivision());
			}
		}

		mmNrc.setAddressId(mmNrcDto.getAddressId());
		mmNrc.setOccupation(mmNrcDto.getOccupation());

		if (mmNrcDto.getBloodType() != null) {
			try {
				mmNrc.setBloodType(BloodType.valueOf(mmNrcDto.getBloodType()));
			} catch (IllegalArgumentException e) {
				// Handle invalid blood type (e.g., log warning or throw custom exception)
				System.out.println("WARNING: Invalid BloodType value: " + mmNrcDto.getBloodType());
			}
		}

		return mmNrc;
	}

	public MMnrcDto mmNrcToDto(MMnrc mnNrc) {
		MMnrcDto mmNrcDto = new MMnrcDto();
		mmNrcDto.setId(mnNrc.getId());
		mmNrcDto.setMmId(mnNrc.getMmId());
		mmNrcDto.setName(mnNrc.getName());
		mmNrcDto.setAge(mnNrc.getAge());
		mmNrcDto.setGender(mnNrc.getGender());
		mmNrcDto.setFatherName(mnNrc.getFatherName());
		mmNrcDto.setMotherName(mnNrc.getMotherName());
		mmNrcDto.setIssueDate(mnNrc.getIssueDate());
		mmNrcDto.setDateOfBirth(mnNrc.getDateOfBirth());
		mmNrcDto.setCityOfBirthPlace(mnNrc.getCityOfBirthPlace().toString());
		mmNrcDto.setStateAndDivision(mnNrc.getStateAndDivision().toString());
		mmNrcDto.setAddressId(mnNrc.getAddressId());
		mmNrcDto.setOccupation(mnNrc.getOccupation());
		mmNrcDto.setBloodType(mnNrc.getBloodType().toString());
		return mmNrcDto;
	}

	@Override
	public Employee saveEmployeeAndNrc(ResponseDto responseDto) {
		EmployeeDto employeeDto = responseDto.getEmployee();
		Employee employee = mapToEmployeeFromDto(employeeDto);

		MMnrcDto mmNrcDto = responseDto.getMmnrc();
		MMnrc mmNrc = dtoToMmNrc(mmNrcDto);
		employee.setMmNrc(mmNrc);
		employeeRepository.save(employee);
		// nrcRepository.save(mmNrc);
		return employee;
	}

}
