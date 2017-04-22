package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.TypeOfTesting;
@Entity
@Table(name = "technical_document")
@PrimaryKeyJoinColumn(name = "documnet_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class TechnicalDocument extends Document {

	@Column(name="title",length=200)
	private String title;
	@Column(name="number",length=50)
	private String number;
	@Column(name="ndt_method")
	private TypeOfTesting typeOfTesting;
	
	
	@OneToOne(mappedBy="technicalDocument")
    private Report report;


	public TechnicalDocument() {
		super();
	}

	public TechnicalDocument(long id, LocalDateTime issueDate, String issuedBy, String fileName, String title,
			String number, TypeOfTesting typeOfTesting) {
		super(id, issueDate, issuedBy, fileName);
		this.number = number;
		this.title = title;
		this.typeOfTesting = typeOfTesting;
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

	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}
	
	

	
	@Override
	public String toString() {
		return "TechnicalDocument [title=" + title + ", number=" + number + ", ndtMethod=" + typeOfTesting + ", id=" + id
				+ ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}
	
	

}
