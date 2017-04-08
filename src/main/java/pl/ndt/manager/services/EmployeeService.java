package pl.ndt.manager.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.EmployeeDTO;
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
	
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		List<EmployeeDTO> employessDTO = new ArrayList<>();
		for(Employee employee: employees){
			employessDTO.add(new EmployeeDTO(employee.getFirstName(), employee.getLastName(),employee.getUser().getEmail() ,employee.getEmployeePosition()));
		}
		return employessDTO;
	}

}
