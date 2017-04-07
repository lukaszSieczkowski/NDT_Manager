package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.DocumentIsValid;

public class JaegerTestDTO extends DocumentDTO {

	private boolean correctEyeCondition;

	public JaegerTestDTO() {
		super();
	}

	public JaegerTestDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			boolean correctEyeCondition) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);

		this.correctEyeCondition = correctEyeCondition;
	}

	public boolean getCorrectEyeCondition() {
		return correctEyeCondition;
	}

	public void setCorrectEyeCondition(boolean correctEyeCondition) {
		this.correctEyeCondition = correctEyeCondition;
	}

}
