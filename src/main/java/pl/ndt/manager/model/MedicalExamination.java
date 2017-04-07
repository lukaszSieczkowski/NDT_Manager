package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "medical_examinations")
@PrimaryKeyJoinColumn(name = "document_id")
public class MedicalExamination extends Document {

	@Column(name = "positive_result_test")
	private boolean positiveResultTest;
	@Column(name = "requirements_description")
	private String requirementsDescription;

	public MedicalExamination() {
		super();
	}

	public MedicalExamination(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, boolean positiveResultTest, String requirementsDescription) {
		super(issueDate, expirationDate, issuedBy, fileName, employee);
		this.positiveResultTest = positiveResultTest;
		this.requirementsDescription = requirementsDescription;
	}

	public boolean getPositiveResultTest() {
		return positiveResultTest;
	}

	public void setPositiveResultTest(boolean positiveResultTest) {
		this.positiveResultTest = positiveResultTest;
	}

	public String getRequirementsDescription() {
		return requirementsDescription;
	}

	public void setRequirementsDescription(String requirementsDescription) {
		this.requirementsDescription = requirementsDescription;
	}

	@Override
	public String toString() {
		return "MedicalExamination [positiveResultTest=" + positiveResultTest + ", requirementsDescription="
				+ requirementsDescription + ", id=" + id + ", issueDate=" + issueDate + ", expirationDate="
				+ expirationDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

}
