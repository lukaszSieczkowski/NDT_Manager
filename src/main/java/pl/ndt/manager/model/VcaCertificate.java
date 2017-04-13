package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import pl.ndt.manager.model.enums.NdtMethod;

@Entity
@Table(name = "vca_certificates")
@PrimaryKeyJoinColumn(name = "personal_document_id")
public class VcaCertificate extends PersonalDocument {

	@Column(name = "document_number", length = 40)
	private String documentNumber;

	public VcaCertificate() {
		super();
	}

	public VcaCertificate(long id, LocalDateTime issueDate, String issuedBy, String fileName,
			LocalDateTime expirationDate, Employee employee, String documentNumber) {
		super(id, issueDate, issuedBy, fileName, expirationDate, employee);
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
		return "VcaCertificate [documentNumber=" + documentNumber + ", expirationDate=" + expirationDate + ", employee="
				+ employee + ", id=" + id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName="
				+ fileName + "]";
	}

}
