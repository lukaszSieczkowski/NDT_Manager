package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personal_document")
@PrimaryKeyJoinColumn(name = "documnet_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonalDocument extends Document {

	@Column(name = "expiration_date")
	protected LocalDateTime expirationDate;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	protected Employee employee;
	
	public PersonalDocument() {
		super();
	}

	public PersonalDocument(long id, LocalDateTime issueDate, String issuedBy, String fileName,LocalDateTime expirationDate,Employee employee) {
		super(id, issueDate, issuedBy, fileName);
		this.expirationDate = expirationDate;
		this.employee = employee;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PersonalDocument [expirationDate=" + expirationDate + ", employee=" + employee + ", id=" + id
				+ ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}
	
}
