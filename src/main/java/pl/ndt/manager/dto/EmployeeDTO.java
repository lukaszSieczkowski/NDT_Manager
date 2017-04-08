package pl.ndt.manager.dto;

import pl.ndt.manager.model.enums.EmployeePositon;

public class EmployeeDTO {

	private String firstName;
	private String lastName;
	private String email;
	private EmployeePositon employeePositon;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(String firstName, String lastName, String email, EmployeePositon employeePossiton) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeePositon = employeePossiton;
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

	public EmployeePositon getEmployeePositon() {
		return employeePositon;
	}

	public void setEmployeePositon(EmployeePositon employeePositon) {
		this.employeePositon = employeePositon;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", employeePossiton=" + employeePositon + "]";
	}

}
