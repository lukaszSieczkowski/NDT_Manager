package pl.ndt.manager.model;

import java.util.List;

import javax.persistence.*;

import pl.ndt.manager.model.enums.EmployeePositon;

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
	private EmployeePositon employeePosition;
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Document> documentsList;
	@OneToOne(mappedBy = "employee")
	private User user;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, EmployeePositon employeePossition, List<Document> documentsList,
			User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeePosition = employeePossition;
		this.documentsList = documentsList;
		this.user = user;
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

	
	public EmployeePositon getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(EmployeePositon employeePosition) {
		this.employeePosition = employeePosition;
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
		return "Employee [ firstName=" + firstName + ", lastName=" + lastName + ", employeePossition=" + employeePosition + ", documentsList="
				+ documentsList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentsList == null) ? 0 : documentsList.hashCode());
		result = prime * result + ((employeePosition == null) ? 0 : employeePosition.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (documentsList == null) {
			if (other.documentsList != null)
				return false;
		} else if (!documentsList.equals(other.documentsList))
			return false;
		if (employeePosition != other.employeePosition)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

}
