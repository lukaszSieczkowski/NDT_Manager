package pl.ndt.manager.dto;

import pl.ndt.manager.model.enums.EmployeePossiton;

public class EmployeeDTO {

	private String firstName;
	private String lastName;
	private String email;
	private EmployeePossiton employeePossiton;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(String firstName, String lastName, String email, EmployeePossiton employeePossiton) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeePossiton = employeePossiton;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmployeePossiton getEmployeePossiton() {
		return employeePossiton;
	}

	public void setEmployeePossiton(EmployeePossiton employeePossiton) {
		this.employeePossiton = employeePossiton;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", employeePossiton=" + employeePossiton + "]";
	}

}
