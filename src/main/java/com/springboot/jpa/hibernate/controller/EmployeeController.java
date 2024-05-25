package com.springboot.jpa.hibernate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.hibernate.dto.ResponseDto;
import com.springboot.jpa.hibernate.model.Employee;
import com.springboot.jpa.hibernate.service.IEmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class EmployeeController {

	private final IEmployeeService employeeService;

	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@PostMapping("/employees-nrc")
	public ResponseEntity<Employee> saveEmployeeAndNrc(@RequestBody ResponseDto responseDto) {

		Employee savedEmployee = employeeService.saveEmployeeAndNrc(responseDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		try {
			return employeeService.updateEmployee(employee, id);

		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		try {

			return employeeService.deleteEmployee(id);

		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@DeleteMapping("/employees")
	public String deleteAllEmployees() {
		try {

			return employeeService.deleteAllEmployees() + HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage();
		}
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

		return employeeService.getEmployeeById(id);

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		if (employeeList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<>(employeeList, HttpStatus.OK);
		}

	}

}
