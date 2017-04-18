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
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Enumerated
	@Column(name = "employee_possition")
	private EmployeePositon employeePosition;
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PersonalDocument> documentsList;
	@OneToOne(mappedBy = "employee")
	private User user;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	@OneToMany(mappedBy="performer",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Report> performedReportsList;
	@OneToMany(mappedBy="aprover",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Report> approvedReportsList;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, EmployeePositon employeePossition,
			List<PersonalDocument> documentsList, User user, Location location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeePosition = employeePossition;
		this.documentsList = documentsList;
		this.user = user;
		this.location = location;
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

	public List<PersonalDocument> getDocumentsList() {
		return documentsList;
	}

	public void setDocumentsList(List<PersonalDocument> documentList) {
		this.documentsList = documentList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employeePosition="
				+ employeePosition + "]";
	}

}
