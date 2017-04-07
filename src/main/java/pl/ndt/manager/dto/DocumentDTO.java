package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class DocumentDTO {

	protected String issueDate;

	protected String expirationDate;

	protected String issuedBy;
	protected MultipartFile file;
	protected String fileDirectory;
	protected String email;
	protected String ownersNameAndSurname;
	protected DocumentIsValid documentIsValid;

	public DocumentDTO() {
		super();
	}

	public DocumentDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid) {
		super();
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.issuedBy = issuedBy;
		this.file = file;
		this.fileDirectory = fileDirectory;
		this.email = email;
		this.ownersNameAndSurname = ownersNameAndSurname;
		this.documentIsValid = documentIsValid;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getEmail() {
		return email;
	}

	public String getOwnersNameAndSurname() {
		return ownersNameAndSurname;
	}

	public void setOwnersNameAndSurname(String ownersNameAndSurname) {
		this.ownersNameAndSurname = ownersNameAndSurname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DocumentIsValid getDocumentIsValid() {
		return documentIsValid;
	}

	public void setDocumentIsValid(DocumentIsValid documentIsValid) {
		this.documentIsValid = documentIsValid;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DocumentDTO [issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy
				+ ", file=" + file + ", email=" + email + ", ownersNameAndSurname=" + ownersNameAndSurname + "]";
	}

}
