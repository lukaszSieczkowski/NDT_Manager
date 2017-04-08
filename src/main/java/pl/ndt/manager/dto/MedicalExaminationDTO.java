package pl.ndt.manager.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class MedicalExaminationDTO extends DocumentDTO {

	@NotBlank(message = "This field may not be empty")
	@Size(max=500, message="To long sentence. Only 500 signs allowed")
	private String requirementsDescription;
	
	@NotBlank(message = "This field may not be empty")
	@Size(max=200, message="To long sentence. Only 200 signs allowed")
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
