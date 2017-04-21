package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.CustomerDTO;

import pl.ndt.manager.model.Address;
import pl.ndt.manager.model.Customer;

import pl.ndt.manager.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	private List<CustomerDTO> customers;

	/**
	 * Creates list of all Customers
	 * 
	 * @return Customers list
	 */
	public List<CustomerDTO> getCustomers() {
		List<Customer> customersList = (List<Customer>) customerRepository.findAll();
		customers = new ArrayList<>();
		for (Customer customer : customersList) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setId(customer.getId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setStreet(customer.getAddress().getStreet());
			customerDTO.setHouseNumber(String.valueOf(customer.getAddress().getHouseNumber()));
			customerDTO.setLocalNumber(String.valueOf(customer.getAddress().getLocalNumber()));
			customerDTO.setCity(customer.getAddress().getCity());
			customerDTO.setZipCode(customer.getAddress().getZipCode());
			customers.add(customerDTO);
		}
		return customers;
	}

	/**
	 * Saves Customer in database
	 * 
	 * @param customerDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */

	public void saveCustomer(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		Address address = new Address();

		address.setStreet(customerDTO.getStreet());
		address.setHouseNumber(Integer.parseInt(customerDTO.getHouseNumber()));
		address.setLocalNumber(Integer.parseInt(customerDTO.getLocalNumber()));
		address.setCity(customerDTO.getCity());
		address.setZipCode(customerDTO.getZipCode());
		customer.setId(customerDTO.getId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setAddress(address);
		
		Long customerNumber =customerRepository.count();
		customer.setCustomerNumber(customerNumber);

		customerRepository.save(customer);
	}
}
