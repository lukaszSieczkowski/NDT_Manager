package pl.ndt.manager.dto;

import java.time.LocalDateTime;

public class JaegerTestDTO extends DocumentDTO{
	
	private boolean correctEyeCondition;

	public JaegerTestDTO() {
		super();
	}

	public JaegerTestDTO(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			String ownerFirstName, String ownerLastName, boolean correctEyeCondition) {
		super(issueDate, expirationDate, issuedBy, fileName, ownerFirstName, ownerLastName);
		
		this.correctEyeCondition= correctEyeCondition;
	}

	public boolean getCorrectEyeCondition() {
		return correctEyeCondition;
	}

	public void setCorrectEyeCondition(boolean correctEyeCondition) {
		this.correctEyeCondition = correctEyeCondition;
	}
	
}
