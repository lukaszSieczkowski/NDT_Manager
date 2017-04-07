package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class MedicalExaminationDTO extends DocumentDTO {

	private boolean positiveResultTest;
	private String requirementsDescription;

	public MedicalExaminationDTO() {
		super();
	}

	public MedicalExaminationDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			boolean positiveResultTest, String requirementsDescription) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);
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
