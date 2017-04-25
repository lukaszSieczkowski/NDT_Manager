package pl.ndt.manager.dto;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class VisualReportDetailsDTO {

	@Size(max = 200, message="To long sentence. Only 200 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String examinatedObject;
	@NotEmpty(message = "Select equipment")
	private String measuringEquipment;
	@NotEmpty(message = "Select standard")
	private String technicalDocument;

	@NotEmpty(message = "Select employee")
	private String aproverEmail;
	@DecimalMin(value = "0",message="Incorrect value")
	@NotBlank(message = "This field may not be empty")
	private String lighting;
	
	public VisualReportDetailsDTO() {
		super();
	}
	public String getExaminatedObject() {
		return examinatedObject;
	}
	public void setExaminatedObject(String examinatedObject) {
		this.examinatedObject = examinatedObject;
	}
	
	
	
	public String getMeasuringEquipment() {
		return measuringEquipment;
	}
	public void setMeasuringEquipment(String measuringEquipment) {
		this.measuringEquipment = measuringEquipment;
	}
	public String getTechnicalDocument() {
		return technicalDocument;
	}
	public void setTechnicalDocument(String technicalDocument) {
		this.technicalDocument = technicalDocument;
	}
	
	public String getAproverEmail() {
		return aproverEmail;
	}
	public void setAproverEmail(String aproverEmail) {
		this.aproverEmail = aproverEmail;
	}
	public String getLighting() {
		return lighting;
	}
	public void setLighting(String lighting) {
		this.lighting = lighting;
	}
	@Override
	public String toString() {
		return "VisualReportDetailsDTO [examinatedObject=" + examinatedObject + ", measuringEquipment="
				+ measuringEquipment + ", technicalDocument=" + technicalDocument 
				+ ", aproverEmail=" + aproverEmail + ", lighting=" + lighting + "]";
	}
	
	
}
