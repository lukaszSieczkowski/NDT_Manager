package pl.ndt.manager.model;

import java.util.List;

import javax.persistence.*;

import pl.ndt.manager.model.enums.EmployeePossiton;
import pl.ndt.manager.model.enums.UserRole;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private UserRole role;
	@Column(name = "employee_possition")
	private EmployeePossiton employeePossition;
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Document> documentsList;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String password, UserRole role,
			EmployeePossiton employeePossition) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.employeePossition = employeePossition;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public EmployeePossiton getEmployeePossition() {
		return employeePossition;
	}

	public void setEmployeePossition(EmployeePossiton employeePossition) {
		this.employeePossition = employeePossition;
	}

	public List<Document> getDocumentsList() {
		return documentsList;
	}

	public void setDocumentsList(List<Document> documentsList) {
		this.documentsList = documentsList;
	}

	@Override
	public String toString() {
		return "Employee [ firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", role=" + role + ", employeePossition=" + employeePossition + ", documentsList="
				+ documentsList + "]";
	}

}
