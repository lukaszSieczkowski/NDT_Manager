package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.Sector;

@Entity
@Table(name = "ndt_certificates")
@PrimaryKeyJoinColumn(name = "personal_document_id")
public class NdtCertificate extends PersonalDocument{

	@Column(name = "document_number", length = 40)
	private String documentNumber;
	@Enumerated
	@Column(name = "sector")
	private Sector sector;
	@Enumerated
	@Column(name = "ndt_method")
	private NdtMethod ndtMethod;

	public NdtCertificate() {

	}

	public NdtCertificate(long id, LocalDateTime issueDate, String issuedBy, String fileName,
			LocalDateTime expirationDate, Employee employee,String documentNumber,Sector sector,NdtMethod ndtMethod) {
		super(id, issueDate, issuedBy, fileName, expirationDate, employee);
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
		return "NdtCertificate [documentNumber=" + documentNumber + ", sector=" + sector + ", ndtMethod=" + ndtMethod
				+ ", expirationDate=" + expirationDate + ", employee=" + employee + ", id=" + id + ", issueDate="
				+ issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

	
	

	
}
