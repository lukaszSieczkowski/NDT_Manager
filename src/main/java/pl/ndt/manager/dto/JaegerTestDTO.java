package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.CorerctlyEyeCondition;
import pl.ndt.manager.model.enums.DocumentIsValid;

public class JaegerTestDTO extends PersonalDocumentDTO {
	
	@NotNull(message = "Select Value")
	private CorerctlyEyeCondition corerctlyEyeCondition;

	public JaegerTestDTO() {
		super();
	}

	public JaegerTestDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory,
			String expirationDate, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			 CorerctlyEyeCondition corerctlyEyeCondition) {
		super(id, issueDate, issuedBy, file, fileDirectory, expirationDate, email, ownersNameAndSurname, documentIsValid);
		this.corerctlyEyeCondition = corerctlyEyeCondition;
	}

	public CorerctlyEyeCondition getCorerctlyEyeCondition() {
		return corerctlyEyeCondition;
	}

	public void setCorerctlyEyeCondition(CorerctlyEyeCondition corerctlyEyeCondition) {
		this.corerctlyEyeCondition = corerctlyEyeCondition;
	}

	@Override
	public String toString() {
		return "JaegerTestDTO [corerctlyEyeCondition=" + corerctlyEyeCondition + ", expirationDate=" + expirationDate
				+ ", email=" + email + ", ownersNameAndSurname=" + ownersNameAndSurname + ", documentIsValid="
				+ documentIsValid + ", id=" + id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", file="
				+ file + ", fileDirectory=" + fileDirectory + "]";
	}

}
