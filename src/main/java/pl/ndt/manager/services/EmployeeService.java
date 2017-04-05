package pl.ndt.manager.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.UserDTO;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	

	
	/**
	 * Prepares list of all employees
	 * @return Employees list
	 */
	
	public List<Employee> showAllEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		return employees;
	}

}
