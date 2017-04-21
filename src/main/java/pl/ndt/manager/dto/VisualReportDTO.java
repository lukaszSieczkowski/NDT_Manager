package pl.ndt.manager.dto;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

public class VisualReportDTO extends ReportDTO {
	
	private String lighting;

	public VisualReportDTO() {
		super();
	}

	public String getLighting() {
		return lighting;
	}

	public void setLighting(String lighting) {
		this.lighting = lighting;
	}

	
	
	
}
