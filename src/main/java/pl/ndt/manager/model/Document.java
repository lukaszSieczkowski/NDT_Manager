package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "document")
public class Document {

	@Id
	@GeneratedValue
	@Column(name = "id_document")
	protected long id;
	@Column(name = "issue_date")
	protected LocalDateTime issueDate;
	@Column(name = "expiration_date")
	protected LocalDateTime expirationDate;
	@Column(name = "issued_by")
	protected String issuedBy;
	@Column(name = "file_name")
	protected String fileName;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	protected Employee employee;

	public Document() {

	}

	public Document(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee) {
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.issuedBy = issuedBy;
		this.fileName = fileName;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy="
				+ issuedBy + ", fileName=" + fileName + "]";
	}

}
