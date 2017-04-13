package pl.ndt.manager.controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.components.LocationsList;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.services.EmployeeService;
import pl.ndt.manager.services.LocationService;

@Controller
@SessionAttributes("locations")
public class EmployeeController {

	@Autowired
	private EmployeeList employeeList;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private LocationsList locationsList;

	/**
	 * Shows list of all employees
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showEmployees view
	 */
	@RequestMapping("/showEmployees")
	public String showAllEmployees(Model model) {
		ArrayList<EmployeeDTO> employees = (ArrayList<EmployeeDTO>) employeeService.getAllEmployees();

		employeeList.setEmployees(employees);
		model.addAttribute("employess", employeeList);
		return "personel/showEmployees";
	}

	/**
	 * Shows form to save Employee in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addEmployee view
	 */

	@RequestMapping("/addEmployee")
	public String addEmployee(Model model) {

		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		model.addAttribute("employeeDTO", new EmployeeDTO());
		model.addAttribute("locations", locationsList);
		return "personel/add_employee/addEmployee";
	}

	/**
	 * Saves new Business Location System
	 * 
	 * @param employeeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addEmployee view
	 */

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult result, Model model) {
		String alert;
		if (!result.hasErrors()) {

			List<EmployeeDTO> employessDTO = employeeService.getAllEmployees();
			Optional<EmployeeDTO> optionalEmployeeDTO = employessDTO.stream()
					.filter(a -> (a.getEmail().equals(employeeDTO.getEmail()))).findAny();
			if (!optionalEmployeeDTO.isPresent()) {
			//	try {
					employeeService.saveEmployee(employeeDTO);
			//	} catch (Exception e) {
				alert = "Something went wrong. Employee wasn't saved successfully";
			//		model.addAttribute("alert", alert);
			//		return "personel/add_employee/addEmployee";
			//	}
			//	alert = "Employee was saved successfully";

			} else {
				alert = "Employee already exist. Change email address";
			}
			model.addAttribute("alert", alert);
		}
		return "personel/add_employee/addEmployee";
	}

	/**
	 * Shows form for editing Employee
	 * 
	 * @param id
	 *            Employee id
	 * @param model
	 *            Holder for attributes
	 * @return editEmployee view
	 */
	@RequestMapping("/editEmployee")
	public String editEmployee(@RequestParam("id") Long id, Model model) {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		Optional<EmployeeDTO> optionalEmployeeDTO = employees.stream().filter(a -> (a.getId() == id)).findAny();
		EmployeeDTO employeeDTO = (EmployeeDTO) optionalEmployeeDTO.get();
		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		System.out.println("Ediy employee " + employeeDTO);
		model.addAttribute("locations", locationsList);
		model.addAttribute("employeeDTO", employeeDTO);
		return "personel/edit_employee/editEmployee";
	}

	/**
	 * Updates Employee
	 * 
	 * @param employeeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param id
	 *            Employee id
	 * @param model
	 *            Holder for attributes
	 * @return editEmployee view
	 */
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		System.out.println("Update" + employeeDTO);
		if (!result.hasErrors()) {
			String alert = null;
			employeeDTO.setId(id);
			try {
				employeeService.updateEmployee(employeeDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Employee wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "personel/edit_employee/editEmployee";
			}
			alert = "Employee was updated successfully";
			model.addAttribute("alert", alert);
		}
		return "personel/edit_employee/editEmployee";
	}

}
