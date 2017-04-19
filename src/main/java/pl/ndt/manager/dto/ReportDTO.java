package pl.ndt.manager.dto;

import java.time.LocalDateTime;
import java.util.List;

import pl.ndt.manager.model.enums.NdtMethod;

public class ReportDTO {

	private long id;
	private String customer;
	private String reportNumber;
	private String place;
	private String orderNumber;
	private String examinatedObject;
	private List<EquipmentDTO> measuringEquipmentList;
	private List<String> technicalDocumentList;
	private String examinationDate;
	private String qualityLevel;
	private String performer;
	private String aprover;
	private String typeOfTesting;

	private List<ResultOfExaminationDTO> resultsOfExaminationtsList;

	public ReportDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
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

	public String getExaminatedObject() {
		return examinatedObject;
	}

	public void setExaminatedObject(String examinatedObject) {
		this.examinatedObject = examinatedObject;
	}

	public List<EquipmentDTO> getMeasuringEquipmentList() {
		return measuringEquipmentList;
	}

	public void setMeasuringEquipmentList(List<EquipmentDTO> measuringEquipmentList) {
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

	public String getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(String qualityLevel) {
		this.qualityLevel = qualityLevel;
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

	public List<ResultOfExaminationDTO> getResultsOfExaminationtsList() {
		return resultsOfExaminationtsList;
	}

	public void setResultsOfExaminationtsList(List<ResultOfExaminationDTO> resultsOfExaminationtsList) {
		this.resultsOfExaminationtsList = resultsOfExaminationtsList;
	}

	public String getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(String typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}

	@Override
	public String toString() {
		return "ReportDTO [customer=" + customer + ", reportNumber=" + reportNumber + ", place=" + place
				+ ", orderNumber=" + orderNumber + ", examinatedObject=" + examinatedObject
				+ ", measuringEquipmentList=" + measuringEquipmentList + ", technicalDocumentList="
				+ technicalDocumentList + ", examinationDate=" + examinationDate + ", qualityLevel=" + qualityLevel
				+ ", performer=" + performer + ", aprover=" + aprover + ", neMethod=" + typeOfTesting
				+ ", resultsOfExaminationtsList=" + resultsOfExaminationtsList + "]";
	}

}
