package pl.ndt.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.dto.LocationDTO;

@Configuration
@ComponentScan
public class BeanConfig {

	/**
	 * Registers EmployeeDTO bean in Spring Container
	 * 
	 * @return employeeDTO
	 */

	@Bean
	public EmployeeDTO getEmployeeDTO() {
		return new EmployeeDTO();
	}

	/**
	 * Registers DocumentDTO bean in Spring Container
	 * 
	 * @return documentDTO
	 */

	@Bean
	public DocumentDTO getDocumentDTO() {
		return new DocumentDTO();
	}
	
	/**
	 * Registers DeviceDTO bean in Spring Container
	 * 
	 * @return deviceDTO;
	 */
	
	@Bean
	public DeviceDTO getDeviceDTO(){
		return new DeviceDTO();
	}
	
	/**
	 * Registers LocationDTO bean in Spring Container
	 * 
	 * @return locationDTO;
	 */
	
	@Bean
	public LocationDTO getLocationDTO(){
		return new LocationDTO();
	}
	
	/**
	 * Registers CustomerDTO bean in Spring Container
	 * 
	 * @return customerDTO;
	 */
	
	@Bean
	public CustomerDTO getCustomerDTO(){
		return new CustomerDTO();
	}

}
