package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "medical_examinations")
@PrimaryKeyJoinColumn(name = "personal_document_id")
public class MedicalExamination extends PersonalDocument {

	@Column(name = "requirements_description",length=500)
	private String requirementsDescription;
	@Column(name = "requirements_full_filled",length=200)
	private String requirementsFullFilled;
	
	public MedicalExamination() {
		super();
	}

	public MedicalExamination(long id, LocalDateTime issueDate, String issuedBy, String fileName,
			LocalDateTime expirationDate, Employee employee, String requirementsDescription,String requirementsFullFilled) {
		super(id, issueDate, issuedBy, fileName, expirationDate, employee);
		this.requirementsDescription=requirementsDescription;
		this.requirementsFullFilled = requirementsFullFilled;
	}

	public String getRequirementsDescription() {
		return requirementsDescription;
	}

	public void setRequirementsDescription(String requirementsDescription) {
		this.requirementsDescription = requirementsDescription;
	}

	public String getRequirementsFullFilled() {
		return requirementsFullFilled;
	}

	public void setRequirementsFullFilled(String requirementsFullFilled) {
		this.requirementsFullFilled = requirementsFullFilled;
	}

	@Override
	public String toString() {
		return "MedicalExamination [requirementsDescription=" + requirementsDescription + ", requirementsFullFilled="
				+ requirementsFullFilled + ", expirationDate=" + expirationDate + ", employee=" + employee + ", id="
				+ id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

	
	

}
