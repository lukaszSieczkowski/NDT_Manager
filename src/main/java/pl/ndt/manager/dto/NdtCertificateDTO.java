package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.Sector;

public class NdtCertificateDTO extends DocumentDTO {
	@NotBlank(message = "This field may not be empty")
	@Size(max=40, message="To long sentence. Only 40 signs allowed")
	private String documentNumber;
	@NotNull(message = "Select Sector")
	private Sector sector;
	@NotNull(message = "Select NDT Method")
	private NdtMethod ndtMethod;

	public NdtCertificateDTO() {
		super();
	}

	public NdtCertificateDTO(Long id,String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			String documentNumber, Sector sector, NdtMethod ndtMethod) {
		super(id,issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);
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
				+ ", id=" + id + ", issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy="
				+ issuedBy + ", file=" + file + ", fileDirectory=" + fileDirectory + ", email=" + email
				+ ", ownersNameAndSurname=" + ownersNameAndSurname + ", documentIsValid=" + documentIsValid + "]";
	}

	

	
	
	
	

}
