package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.NdtMethod;
@Entity
@Table(name = "technical_document")
@PrimaryKeyJoinColumn(name = "documnet_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class TechnicalDocument extends Document {

	@Column(name="title")
	private String title;
	@Column(name="number")
	private String number;
	@Column(name="ndt_method")
	private NdtMethod ndtMethod;

	public TechnicalDocument() {
		super();
	}

	public TechnicalDocument(long id, LocalDateTime issueDate, String issuedBy, String fileName, String title,
			String number, NdtMethod ndtMethod) {
		super(id, issueDate, issuedBy, fileName);
		this.number = number;
		this.title = title;
		this.ndtMethod = ndtMethod;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public NdtMethod getNdtMethod() {
		return ndtMethod;
	}

	public void setNdtMethod(NdtMethod ndtMethod) {
		this.ndtMethod = ndtMethod;
	}

	@Override
	public String toString() {
		return "TechnicalDocument [title=" + title + ", number=" + number + ", ndtMethod=" + ndtMethod + ", id=" + id
				+ ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}
	
	

}
