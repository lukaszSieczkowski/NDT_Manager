package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jaeger_test")
public class JaegerTest extends Document {

	@Column(name = "correct_eye_condition")
	private boolean correctEyeCondition;

	public JaegerTest() {
		super();
	}

	public JaegerTest(LocalDateTime issueDate, LocalDateTime expirationDate, String issuedBy, String fileName,
			Employee employee, boolean correctEyeCondition) {
		super(issueDate, expirationDate, issuedBy, fileName, employee);
		this.correctEyeCondition = correctEyeCondition;
	}

	public boolean isCorrectEyeCondition() {
		return correctEyeCondition;
	}

	public void setCorrectEyeCondition(boolean correctEyeCondition) {
		this.correctEyeCondition = correctEyeCondition;
	}

	@Override
	public String toString() {
		return "JaegerTest [correctEyeCondition=" + correctEyeCondition + ", id=" + id + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy + ", fileName=" + fileName + "]";
	}

}
