package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="jaeger_test")
public class JaegerTest extends Document{
	
	@Column(name="correct_eye_condition")
	private boolean correctEyeCondition;

	public JaegerTest() {
		super();
	}
	
	

}
