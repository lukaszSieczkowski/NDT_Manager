package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import pl.ndt.manager.model.enums.NdtMethods;

@Entity
public class NdtCertificate extends Document {

	@Column(name = "document_number")
	private String documentNumber;
	@Column(name = "sector")
	private String sector;
	@Column(name = "ndt_method")
	@Enumerated
	private NdtMethods ndtMethod;

	public NdtCertificate() {

	}

	public NdtCertificate(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, String documentNumber, String sector, NdtMethods ndtMethod) {
		super(issueDate, expirationDate, issuedBy, fileName, employee);
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

	public NdtMethods getNdtMethod() {
		return ndtMethod;
	}

	public void setNdtMethod(NdtMethods ndtMethod) {
		this.ndtMethod = ndtMethod;
	}

	@Override
	public String toString() {
		return "NdtCertificate [documentNumber=" + documentNumber + ", sector=" + sector + ", ndtMethod=" + ndtMethod
				+ ", id=" + id + ", issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy="
				+ issuedBy + ", fileName=" + fileName + "]";
	}

}
