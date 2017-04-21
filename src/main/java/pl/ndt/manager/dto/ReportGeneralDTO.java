package pl.ndt.manager.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pl.ndt.manager.model.enums.TypeOfTesting;

public class ReportGeneralDTO {
	@NotNull(message = "Select customer")
	private Long customerId;
	@Size(max = 200, message="To long sentence. Only 200 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String place;
	@Size(max = 50, message="To long sentence. Only 50 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String orderNumber;
	@NotEmpty(message = "Select quality level")
	private String qualityLevel;
	@NotNull(message = "Select NDT method")
	private TypeOfTesting typeOfTesting;
	
	private String examinationDate;
	
	
	public ReportGeneralDTO() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getQualityLevel() {
		return qualityLevel;
	}
	public void setQualityLevel(String qualityLevel) {
		this.qualityLevel = qualityLevel;
	}
	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}
	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}

	public String getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(String examinationDate) {
		this.examinationDate = examinationDate;
	}
	
	
}
