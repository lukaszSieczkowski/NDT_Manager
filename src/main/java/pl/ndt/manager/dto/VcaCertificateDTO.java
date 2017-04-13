package pl.ndt.manager.dto;

import java.io.File;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class VcaCertificateDTO extends PersonalDocumentDTO {
	@NotBlank(message = "This field may not be empty")
	@Size(max = 40, message = "To long sentence. Only 40 signs allowed")
	private String documentNumber;

	public VcaCertificateDTO() {
		super();
	}

	public VcaCertificateDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory,
			String expirationDate, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			String documentNumber) {
		super(id, issueDate, issuedBy, file, fileDirectory, expirationDate, email, ownersNameAndSurname,
				documentIsValid);
		this.documentNumber = documentNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public String toString() {
		return "VcaCertificateDTO [documentNumber=" + documentNumber + ", expirationDate=" + expirationDate + ", email="
				+ email + ", ownersNameAndSurname=" + ownersNameAndSurname + ", documentIsValid=" + documentIsValid
				+ ", id=" + id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", file=" + file
				+ ", fileDirectory=" + fileDirectory + "]";
	}

}
