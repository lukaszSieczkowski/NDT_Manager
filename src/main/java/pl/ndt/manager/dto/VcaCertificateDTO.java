package pl.ndt.manager.dto;

import java.time.LocalDateTime;

public class VcaCertificateDTO extends DocumentDTO {
	
	private String documentNumber;

	public VcaCertificateDTO() {
		super();
	}

	public VcaCertificateDTO(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			String ownerFirstName, String ownerLastName,String documentNumber) {
		super(issueDate, expirationDate, issuedBy, fileName, ownerFirstName, ownerLastName);
		this.documentNumber = documentNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

}
