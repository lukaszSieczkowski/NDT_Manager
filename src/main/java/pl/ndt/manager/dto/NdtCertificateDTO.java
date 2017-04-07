package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.Sector;

public class NdtCertificateDTO extends DocumentDTO {

	private String documentNumber;
	private Sector sector;
	private NdtMethod ndtMethod;

	public NdtCertificateDTO() {
		super();
	}

	public NdtCertificateDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			String documentNumber, Sector sector, NdtMethod ndtMethod) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);
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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public NdtMethod getNdtMethod() {
		return ndtMethod;
	}

	public void setNdtMethod(NdtMethod ndtMethod) {
		this.ndtMethod = ndtMethod;
	}

	@Override
	public String toString() {
		return "NdtCertificateDTO [documentNumber=" + documentNumber + ", sector=" + sector + ", ndtMethod=" + ndtMethod
				+ ", issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy
				+ ", file=" + file + ", email=" + email + ", ownersNameAndSurname=" + ownersNameAndSurname + "]";
	}

}
