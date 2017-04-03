package pl.ndt.manager.dto;

import java.time.LocalDateTime;

public class DocumentDTO {
	
	protected LocalDateTime issueDate;
	protected LocalDateTime expirationDate;
	protected String issuedBy;
	protected String fileName;
	protected String ownerFirstName;
	protected String ownerLastName;

	public DocumentDTO() {
		super();
	}

	public DocumentDTO(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			String ownerFirstName, String ownerLastName) {
		super();
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.issuedBy = issuedBy;
		this.fileName = fileName;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
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

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

}
