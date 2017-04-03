package pl.ndt.manager.dto;

import java.time.LocalDateTime;

public class MedicalExaminationDTO extends DocumentDTO{
	
	private boolean positiveResultTest;
	private String requirementsDescription;
	
	public MedicalExaminationDTO() {
		super();
	}

	public MedicalExaminationDTO(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy,
			String fileName, String ownerFirstName, String ownerLastName,boolean positiveResultTest,
			String requirementsDescription ) {
		super(issueDate, expirationDate, issuedBy, fileName, ownerFirstName, ownerLastName);
		this.positiveResultTest = positiveResultTest;
		this.requirementsDescription = requirementsDescription;
	}

	public boolean isPositiveResultTest() {
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
	
}
