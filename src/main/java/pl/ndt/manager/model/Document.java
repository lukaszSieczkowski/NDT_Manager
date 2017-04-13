package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document")
	protected long id;
	@Column(name = "issue_date")
	protected LocalDateTime issueDate;
	@Column(name = "issued_by", length=50)
	protected String issuedBy;
	@Column(name = "file_name")
	protected String fileName;
	

	public Document() {

	}
	

	public Document(long id, LocalDateTime issueDate, String issuedBy, String fileName) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.issuedBy = issuedBy;
		this.fileName = fileName;
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


	@Override
	public String toString() {
		return "Document [id=" + id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName
				+ "]";
	}


}
