package pl.ndt.manager.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.CustomersList;

import pl.ndt.manager.dto.CustomerDTO;

import pl.ndt.manager.services.CustomerService;

@Controller
@SessionAttributes("customers")
public class CustomerControler {

	@Autowired
	private CustomersList customers;
	@Autowired
	private CustomerService customerService;

	/**
	 * Shows list of all Customers saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showCustomers view
	 */
	@RequestMapping("/showCustomers")
	public String showAllCustomers(Model model) {
		List<CustomerDTO> customersList = customerService.getCustomers();
		customers.setCustomers(customersList);
		model.addAttribute("customers", customers);
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
	@RequestMapping("/addCustomer")
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
				alert = "Something went wrong. Customer wasn't saved successfully";
				model.addAttribute("alert", alert);
				return "customers/add_customer/addCustomer";
			}
			alert = "Customer was saved successfully";
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
		List<CustomerDTO> customers = customerService.getCustomers();
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

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			customerDTO.setId(id);
			try {
				customerService.saveCustomer(customerDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Customer wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "customers/edit_customer/editCustomer";
			}
			alert = "Customer was updated successfully";
			model.addAttribute("alert", alert);
		}
		return "customers/edit_customer/editCustomer";
	}

}
