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
	private List<String> measuringEquipmentList;
	@NotEmpty(message = "Select standard")
	private List<String> technicalDocumentList;
	@NotEmpty(message = "Select employeer")
	private String performerEmail;
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
	public List<String> getMeasuringEquipmentList() {
		return measuringEquipmentList;
	}
	public void setMeasuringEquipmentList(List<String> measuringEquipmentList) {
		this.measuringEquipmentList = measuringEquipmentList;
	}
	public List<String> getTechnicalDocumentList() {
		return technicalDocumentList;
	}
	public void setTechnicalDocumentList(List<String> technicalDocumentList) {
		this.technicalDocumentList = technicalDocumentList;
	}
	public String getPerformerEmail() {
		return performerEmail;
	}
	public void setPerformerEmail(String performerEmail) {
		this.performerEmail = performerEmail;
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
	
	
}
