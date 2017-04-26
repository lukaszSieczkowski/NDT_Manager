package pl.ndt.manager.controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.ndt.manager.components.AlertComponent;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.components.LocationsList;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.model.enums.Objects;
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
	@Autowired
	private AlertComponent alertComponent;

	/**
	 * Shows list of all employees
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showEmployees view
	 */
	@GetMapping("/showEmployees")
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

	@GetMapping("/addEmployee")
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

	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult result, Model model) {
		String alert;
		if (!result.hasErrors()) {
			List<EmployeeDTO> employessDTO = employeeService.getAllEmployees();
			Optional<EmployeeDTO> optionalEmployeeDTO = employessDTO.stream()
					.filter(a -> (a.getEmail().equals(employeeDTO.getEmail()))).findAny();
			if (!optionalEmployeeDTO.isPresent()) {
				try {
					employeeService.saveEmployee(employeeDTO);
				} catch (Exception e) {
					alert = alertComponent.savedUnsucesfully(Objects.EMPLOYEE);
					model.addAttribute("alert", alert);
					return "personel/add_employee/addEmployee";
				}
				alert = alertComponent.savedSucesfully(Objects.EMPLOYEE);

			} else {
				alert = alertComponent.exist(Objects.EMPLOYEE);
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
	@GetMapping("/editEmployee")
	public String editEmployee(@RequestParam("id") Long id, Model model) {

		List<EmployeeDTO> employees = employeeList.getEmployees();
		Optional<EmployeeDTO> optionalEmployeeDTO = employees.stream().filter(a -> (a.getId() == id)).findAny();
		EmployeeDTO employeeDTO = (EmployeeDTO) optionalEmployeeDTO.get();
		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		
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
	@PostMapping("/updateEmployee")
	public String updateEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
	
		if (!result.hasErrors()) {
			String alert = null;
			employeeDTO.setId(id);
			try {
				employeeService.updateEmployee(employeeDTO);
			} catch (Exception e) {
				alert = alertComponent.savedUnsucesfully(Objects.EMPLOYEE);
				model.addAttribute("alert", alert);
				return "personel/edit_employee/editEmployee";
			}
			alert = alertComponent.savedSucesfully(Objects.EMPLOYEE);
			model.addAttribute("alert", alert);
		}
		return "personel/edit_employee/editEmployee";
	}

}
