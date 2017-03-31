package pl.ndt.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.ndt.manager.model.Employee;

@Configuration
@ComponentScan(value = "pl.ndt.manager.model")
public class BeanConfig {

	/**
	 * Registers Employee bean in Spring Container
	 * 
	 * @return user
	 */

	@Bean
	public Employee getEmployee() {
		return new Employee();
	}
}
