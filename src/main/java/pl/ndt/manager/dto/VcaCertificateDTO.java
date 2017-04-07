package pl.ndt.manager.dto;

import java.io.File;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class VcaCertificateDTO extends DocumentDTO {

	private String documentNumber;

	public VcaCertificateDTO() {
		super();
	}

	public VcaCertificateDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			String documentNumber) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);
		this.documentNumber = documentNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

}
