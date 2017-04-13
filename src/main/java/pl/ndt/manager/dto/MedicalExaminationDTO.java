package pl.ndt.manager.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class MedicalExaminationDTO extends PersonalDocumentDTO {

	@NotBlank(message = "This field may not be empty")
	@Size(max = 500, message = "To long sentence. Only 500 signs allowed")
	private String requirementsDescription;
	@NotBlank(message = "This field may not be empty")
	@Size(max = 200, message = "To long sentence. Only 200 signs allowed")
	private String requirementsFullFilled;

	public MedicalExaminationDTO() {
		super();
	}

	public MedicalExaminationDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory,
			String expirationDate, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			String requirementsDescription, String requirementsFullFilled) {
		super(id, issueDate, issuedBy, file, fileDirectory, expirationDate, email, ownersNameAndSurname,
				documentIsValid);
		this.requirementsDescription = requirementsDescription;
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
		return "MedicalExaminationDTO [requirementsDescription=" + requirementsDescription + ", requirementsFullFilled="
				+ requirementsFullFilled + ", expirationDate=" + expirationDate + ", email=" + email
				+ ", ownersNameAndSurname=" + ownersNameAndSurname + ", documentIsValid=" + documentIsValid + ", id="
				+ id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", file=" + file + ", fileDirectory="
				+ fileDirectory + "]";
	}

}
