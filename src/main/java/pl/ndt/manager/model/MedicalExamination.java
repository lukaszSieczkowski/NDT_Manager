package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "medical_examinations")
@PrimaryKeyJoinColumn(name = "document_id")
public class MedicalExamination extends Document {

	@Column(name = "requirements_description",length=500)
	private String requirementsDescription;
	@Column(name = "requirements_full_filled",length=200)
	private String requirementsFullFilled;
	
	public MedicalExamination() {
		super();
	}

	public MedicalExamination(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, String requirementsFullFilled, String requirementsDescription) {
		super(issueDate, expirationDate, issuedBy, fileName, employee);
		this.requirementsFullFilled = requirementsFullFilled;
		this.requirementsDescription = requirementsDescription;
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
		return "MedicalExamination [positiveResultTest=" +  requirementsFullFilled + ", requirementsDescription="
				+ requirementsDescription + ", id=" + id + ", issueDate=" + issueDate + ", expirationDate="
				+ expirationDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

}
