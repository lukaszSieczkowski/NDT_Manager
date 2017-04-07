package pl.ndt.manager.components;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import pl.ndt.manager.dto.EmployeeDTO;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeList {

	private List<EmployeeDTO> employees;

	public EmployeeList() {
		super();
	}

	public EmployeeList(List<EmployeeDTO> employees) {
		super();
		this.employees = employees;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

}
