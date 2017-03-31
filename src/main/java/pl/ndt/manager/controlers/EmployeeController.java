package pl.ndt.manager.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.repository.EmployeeRepository;
import pl.ndt.manager.services.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeList employeeList;
	
	private EmployeeService serviceEmployee;
	
	@Autowired
	public EmployeeController(EmployeeList employeeList, EmployeeService serviceEmployee){
		this.employeeList = employeeList;
		this.serviceEmployee = serviceEmployee;
	}
	
	@RequestMapping("/showEmployees")
	public void showAllEmployees(){
		ArrayList<Employee>employees =   serviceEmployee.getAllEmployees();
		System.out.println(employees);
		employeeList.setEmployees(employees);
			
	}

}
