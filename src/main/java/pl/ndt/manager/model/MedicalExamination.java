package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MedicalExamination extends Document {
	
	@Column(name="positive_result_test")
	private boolean positiveResultTest;
	@Column(name="requirements_description")
	private String requirementsDescription;

	public MedicalExamination() {
		super();
	}
	
}
