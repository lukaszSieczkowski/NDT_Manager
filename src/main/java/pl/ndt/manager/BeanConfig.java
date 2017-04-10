package pl.ndt.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.EmployeeDTO;

@Configuration
@ComponentScan
public class BeanConfig {

	/**
	 * Registers Employee bean in Spring Container
	 * 
	 * @return employee
	 */

	@Bean
	public EmployeeDTO getEmployeeDTO() {
		return new EmployeeDTO();
	}

	/**
	 * Registers Document bean in Spring Container
	 * 
	 * @return document
	 */

	@Bean
	public DocumentDTO getDocumentDTO() {
		return new DocumentDTO();
	}
	
	@Bean
	public DeviceDTO getDeviceDTO(){
		return new DeviceDTO();
	}

}
