package pl.ndt.manager.dto;

import pl.ndt.manager.model.enums.UserRole;

public class UserDTO {

	private String firstName;
	private String lastName;
	private UserRole role;

	public UserDTO() {
		super();
	}

	public UserDTO(String firstName, String lastName, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
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

}
