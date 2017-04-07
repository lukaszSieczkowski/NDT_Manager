package pl.ndt.manager.controlers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeList employeeList;
	@Autowired
	private EmployeeService serviceEmployee;

	/**
	 * Shows all employees
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showEmployees view
	 */
	@RequestMapping("/showEmployees")
	public String showAllEmployees(Model model) {
		ArrayList<EmployeeDTO> employees = (ArrayList<EmployeeDTO>) serviceEmployee.getAllEmployees();
		employeeList.setEmployees(employees);
		model.addAttribute("employess", employeeList);
		return "personel/showEmployees";
	}

}
