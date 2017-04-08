package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class MedicalExaminationDTO extends DocumentDTO {

	
	private String requirementsDescription;
	
	private String requirementsFullFilled;

	public MedicalExaminationDTO() {
		super();
	}

	public MedicalExaminationDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			 String requirementsFullFilled, String requirementsDescription) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);
		this.requirementsFullFilled = requirementsFullFilled;
		this.requirementsDescription = requirementsDescription;
	}

	
	public String getRequirementsFullFilled() {
		return requirementsFullFilled;
	}

	public void setRequirementsFullFilled(String requirementsFullFilled) {
		this.requirementsFullFilled = requirementsFullFilled;
	}

	public String getRequirementsDescription() {
		return requirementsDescription;
	}

	public void setRequirementsDescription(String requirementsDescription) {
		this.requirementsDescription = requirementsDescription;
	}

}
