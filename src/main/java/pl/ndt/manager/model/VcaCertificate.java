package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "vca_certificates")
@PrimaryKeyJoinColumn(name = "document_id")
public class VcaCertificate extends Document {

	@Column(name = "document_number" ,length=40)
	private String documentNumber;

	public VcaCertificate() {
		super();
	}

	public VcaCertificate(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, String documentNumber) {
		super(issueDate, expirationDate, issuedBy, fileName, employee);
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
		return "VcaCertificate [documentNumber=" + documentNumber + ", id=" + id + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

}
