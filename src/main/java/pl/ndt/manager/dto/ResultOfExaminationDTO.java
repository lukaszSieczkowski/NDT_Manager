package pl.ndt.manager.dto;


import pl.ndt.manager.model.enums.ExaminationResult;

public class ResultOfExaminationDTO {

	private String elementNumber;
	private String distanceFromReferencePoint;
	private String indicationLength;
	private String imperfectionSymbol;
	private ExaminationResult result;
	private String remarks;
	public ResultOfExaminationDTO() {
		super();
	}
	public String getElementNumber() {
		return elementNumber;
	}
	public void setElementNumber(String elementNumber) {
		this.elementNumber = elementNumber;
	}
	public String getDistanceFromReferencePoint() {
		return distanceFromReferencePoint;
	}
	public void setDistanceFromReferencePoint(String distanceFromReferencePoint) {
		this.distanceFromReferencePoint = distanceFromReferencePoint;
	}
	public String getIndicationLength() {
		return indicationLength;
	}
	public void setIndicationLength(String indicationLength) {
		this.indicationLength = indicationLength;
	}
	public String getImperfectionSymbol() {
		return imperfectionSymbol;
	}
	public void setImperfectionSymbol(String imperfectionSymbol) {
		this.imperfectionSymbol = imperfectionSymbol;
	}
	public ExaminationResult getResult() {
		return result;
	}
	public void setResult(ExaminationResult result) {
		this.result = result;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
}
