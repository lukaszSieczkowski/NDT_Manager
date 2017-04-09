package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.Sector;

@Entity
@Table(name = "ndt_certificates")
@PrimaryKeyJoinColumn(name = "document_id")
public class NdtCertificate extends Document {

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

	public NdtCertificate(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, String documentNumber, Sector sector, NdtMethod ndtMethod) {
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
				+ ", id=" + id + ", issueDate=" + issueDate + ", expirationDate=" + expirationDate + ", issuedBy="
				+ issuedBy + ", fileName=" + fileName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documentNumber == null) ? 0 : documentNumber.hashCode());
		result = prime * result + ((ndtMethod == null) ? 0 : ndtMethod.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NdtCertificate other = (NdtCertificate) obj;
		if (documentNumber == null) {
			if (other.documentNumber != null)
				return false;
		} else if (!documentNumber.equals(other.documentNumber))
			return false;
		if (ndtMethod != other.ndtMethod)
			return false;
		if (sector != other.sector)
			return false;
		return true;
	}

}
