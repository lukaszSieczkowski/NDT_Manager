package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import pl.ndt.manager.model.enums.UserRole;

public class UserDTO {
	
	private Long id;

	private String firstName;

	private String lastName;
	
	private UserRole role;
	
	

	public UserDTO() {
		super();
	}

	public UserDTO(String firstName, String lastName, UserRole role, Long id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.id=id;
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
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}

	
}
