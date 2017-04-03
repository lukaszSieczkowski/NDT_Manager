package pl.ndt.manager.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.User;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	

	/**
	 * Creates application user
	 * @param email user's email
	 * @param password user's password
	 * @return user
	 */
	public User createUser(String email, String password) {

		Employee employee = employeeRepository.findByEmail(email);
		if (employee.equals(null)) {
			return null;
		} else {
			if (employee.getPassword().equals(password)) {
				User user = new User(employee.getFirstName(), employee.getLastName(), employee.getRole());
				return user;
			} else {
				return null;
			}
		}
	}

	
	/**
	 * Prepares list of all employees
	 * @return Employees list
	 */
	
	public List<Employee> showAllEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		return employees;
	}

}
