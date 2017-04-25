package pl.ndt.manager.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.ndt.manager.components.AlertComponent;
import pl.ndt.manager.components.CustomersList;
import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.model.enums.Objects;
import pl.ndt.manager.services.CustomerService;

@Controller
@SessionAttributes("customers")
public class CustomerControler {

	@Autowired
	private CustomersList customersList;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AlertComponent alertComponent;

	/**
	 * Shows list of all Customers saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showCustomers view
	 */
	@GetMapping("/showCustomers")
	public String showAllCustomers(Model model) {
		List<CustomerDTO> customers = customerService.getCustomers();
		customersList.setCustomers(customers);
		model.addAttribute("customers", customersList);
		return "customers/show_customers/showCustomers";

	}

	/**
	 * Shows form to save Customer in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addCustomer view
	 */
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customerDTO", new CustomerDTO());
		return "customers/add_customer/addCustomer";
	}

	/**
	 * Saves new Customer in System
	 * 
	 * @param customerDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addCustomer view
	 */

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			try {
				customerService.saveCustomer(customerDTO);
			} catch (Exception e) {
				alert = alertComponent.savedUnsucesfully(Objects.CUSTOMER);
				model.addAttribute("alert", alert);
				return "customers/add_customer/addCustomer";
			}
			alert = alertComponent.savedSucesfully(Objects.CUSTOMER);
			model.addAttribute("alert", alert);
		}
		return "customers/add_customer/addCustomer";
	}

	/**
	 * Shows form for editing Customer
	 * 
	 * @param id
	 *            Customer id
	 * @param model
	 *            Holder for attributes
	 * @return editCustomer view
	 */

	@GetMapping("/editCustomer")
	public String editCustomer(@RequestParam("id") Long id, Model model) {
		List<CustomerDTO> customers = customersList.getCustomers();
		Optional<CustomerDTO> optionalCustomerDTO = customers.stream().filter(a -> (a.getId() == id)).findAny();
		CustomerDTO customerDTO = (CustomerDTO) optionalCustomerDTO.get();

		model.addAttribute("customerDTO", customerDTO);
		return "customers/edit_customer/editCustomer";
	}

	/**
	 * Updates Customer
	 * 
	 * @param customerDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param id
	 *            Customer id
	 * @param model
	 *            Holder for attributes
	 * @return editCustomer view
	 */

	@PostMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			customerDTO.setId(id);
			try {
				customerService.saveCustomer(customerDTO);
			} catch (Exception e) {
				alert= alertComponent.updatedUnsucesfully(Objects.CUSTOMER);
				model.addAttribute("alert", alert);
				return "customers/edit_customer/editCustomer";
			}
			alert =  alertComponent.updateSucesfully(Objects.CUSTOMER);
			model.addAttribute("alert", alert);
		}
		return "customers/edit_customer/editCustomer";
	}

}
