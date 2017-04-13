package pl.ndt.manager.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class PersonalDocumentDTO extends DocumentDTO {
	@NotBlank(message = "This field may not be empty")
	@Size(max=10,min=10, message="Incorect date format")
	protected String expirationDate;
	@Size(min=2,message = "Select Employee")
	protected String email;
	protected String ownersNameAndSurname;
	protected DocumentIsValid documentIsValid;
	
	public PersonalDocumentDTO() {
		super();
	}

	public PersonalDocumentDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory,String expirationDate,
			String email, String ownersNameAndSurname,DocumentIsValid documentIsValid) {
		super(id, issueDate, issuedBy, file, fileDirectory);
		this.expirationDate=expirationDate;
		this.email = email;
		this.ownersNameAndSurname = ownersNameAndSurname;
		this.documentIsValid = documentIsValid;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOwnersNameAndSurname() {
		return ownersNameAndSurname;
	}

	public void setOwnersNameAndSurname(String ownersNameAndSurname) {
		this.ownersNameAndSurname = ownersNameAndSurname;
	}

	public DocumentIsValid getDocumentIsValid() {
		return documentIsValid;
	}

	public void setDocumentIsValid(DocumentIsValid documentIsValid) {
		this.documentIsValid = documentIsValid;
	}

	@Override
	public String toString() {
		return "PersonalDocumentDTO [expirationDate=" + expirationDate + ", email=" + email + ", ownersNameAndSurname="
				+ ownersNameAndSurname + ", documentIsValid=" + documentIsValid + ", id=" + id + ", issueDate="
				+ issueDate + ", issuedBy=" + issuedBy + ", file=" + file + ", fileDirectory=" + fileDirectory + "]";
	}
	
	
	
	
}
