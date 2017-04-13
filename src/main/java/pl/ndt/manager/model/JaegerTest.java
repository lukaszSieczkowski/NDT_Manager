package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import pl.ndt.manager.model.enums.CorerctlyEyeCondition;

@Entity
@Table(name = "jaeger_tests")
@PrimaryKeyJoinColumn(name = "personal_document_id")
public class JaegerTest extends PersonalDocument {

	@Column(name = "correct_eye_condition")
	private CorerctlyEyeCondition corerctlyEyeCondition;

	public JaegerTest() {
		super();
	}


	public JaegerTest(long id, LocalDateTime issueDate, String issuedBy, String fileName, LocalDateTime expirationDate,
			Employee employee,CorerctlyEyeCondition corerctlyEyeCondition) {
		super(id, issueDate, issuedBy, fileName, expirationDate, employee);
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
		return "JaegerTest [correctEyeCondition=" + corerctlyEyeCondition + ", id=" + id + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

}
