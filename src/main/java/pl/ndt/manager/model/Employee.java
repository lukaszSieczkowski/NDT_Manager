package pl.ndt.manager.model;

import java.util.List;

import javax.persistence.*;

import pl.ndt.manager.model.enums.EmployeePossiton;

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
	@Enumerated
	@Column(name = "employee_possition")
	private EmployeePossiton employeePossition;
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Document> documentsList;
	@OneToOne(mappedBy = "employee")
	private User user;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName,
			EmployeePossiton employeePossition) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employee [ firstName=" + firstName + ", lastName=" + lastName + ", employeePossition=" + employeePossition + ", documentsList="
				+ documentsList + "]";
	}

}
