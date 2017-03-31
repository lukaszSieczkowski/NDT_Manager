package pl.ndt.manager.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.model.Employee;
import pl.ndt.manager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
		return employees;
	}
	
	public Employee findEmployee(String email, String password) {

		Employee employee = employeeRepository.findByEmail(email);
		if (employee.equals(null)) {
			return null;
		} else {
			if (employee.getPassword().equals(password)) {
				return employee;
			} else {
				return null;
			}
		}

	}
}
