package pl.ndt.manager.dto;

import java.time.LocalDateTime;

import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.enums.NdtMethod;

public class NdtCertificateDTO extends DocumentDTO {

	private String documentNumber;
	private String sector;
	private NdtMethod ndtMethod;

	public NdtCertificateDTO() {
		super();
	}

	public NdtCertificateDTO(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			String ownerFirstName, String ownerLastName, String documentNumber, String sector, NdtMethod ndtMethod) {
		super(issueDate, expirationDate, issuedBy, fileName, ownerFirstName, ownerLastName);
		this.documentNumber = documentNumber;
		this.sector = sector;
		this.ndtMethod = ndtMethod;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public NdtMethod getNdtMethod() {
		return ndtMethod;
	}

	public void setNdtMethod(NdtMethod ndtMethod) {
		this.ndtMethod = ndtMethod;
	}

}
