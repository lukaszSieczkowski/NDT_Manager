package pl.ndt.manager.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.TypeOfTesting;

public class ReportDTO {

	private Long id;
	private String customerName;
	private Long customerId;
	private String place;
	private String orderNumber;
	private String qualityLevel;
	private TypeOfTesting typeOfTesting;
	private String reportNumber;
	private String examinatedObject;
	private List<String> measuringEquipmentList;
	private List<String> technicalDocumentList;
	private String examinationDate;
	private String performer;
	private String aprover;
	private List<ResultOfExaminationDTO> resultsOfExaminationtsList;

	public ReportDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public String getExaminatedObject() {
		return examinatedObject;
	}

	public void setExaminatedObject(String examinatedObject) {
		this.examinatedObject = examinatedObject;
	}

	

	
	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getAprover() {
		return aprover;
	}

	public void setAprover(String aprover) {
		this.aprover = aprover;
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

	public String getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(String examinationDate) {
		this.examinationDate = examinationDate;
	}


	public List<ResultOfExaminationDTO> getResultsOfExaminationtsList() {
		return resultsOfExaminationtsList;
	}

	public void setResultsOfExaminationtsList(List<ResultOfExaminationDTO> resultsOfExaminationtsList) {
		this.resultsOfExaminationtsList = resultsOfExaminationtsList;
	}

	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
	
}