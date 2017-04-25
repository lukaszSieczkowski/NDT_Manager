package pl.ndt.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.dto.ReportDTO;
import pl.ndt.manager.dto.ResultOfExaminationDTO;
import pl.ndt.manager.dto.VerificationDTO;

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
	

	/**
	 * Registers VerificationDTO bean in Spring Container
	 * 
	 * @return verificationDTO;
	 */
	
	@Bean
	public VerificationDTO getVerificationDTO(){
		return new VerificationDTO();
	}
	
	/**
	 * Registers ReportDTO bean in Spring Container
	 * 
	 * @return reportDTO;
	 */
	
	@Bean
	public ReportDTO getReportDTO(){
		return new ReportDTO();
	}

	
	/**
	 * Registers ResultsOfExaminationDTO bean in Spring Container
	 * 
	 * @return reportDTO;
	 */
	@Bean
	public ResultOfExaminationDTO getResultsOfExaminationDTO(){
		return new ResultOfExaminationDTO();
	}
}
