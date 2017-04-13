package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import pl.ndt.manager.model.enums.EmployeePositon;
import pl.ndt.manager.model.enums.UserRole;

public class EmployeeDTO {

	long id;
	@NotBlank(message = "This field may not be empty")
	@Email(message="Incorect mail format")
	private String email;
	@NotNull(message = "Select employee possition ")
	private EmployeePositon employeePositon;
	@NotBlank(message = "This field may not be empty")
	@Size(max=80, message="To long sentence. Only 60 signs allowed")
	private String locationName;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	private String firstName;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	private String lastName;
	@NotNull(message = "Select user role ")
	private UserRole role;
	
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(long id, String email, EmployeePositon employeePositon, String locationName, String firstName,
			String lastName, UserRole role) {
		super();
		this.id = id;
		this.email = email;
		this.employeePositon = employeePositon;
		this.locationName = locationName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", email=" + email + ", employeePositon=" + employeePositon + ", locationName="
				+ locationName + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}
	
}
