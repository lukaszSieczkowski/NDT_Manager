package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.ndt.manager.model.enums.ExaminationResult;


@Entity
public class ResultsOfExamination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="element_number")
	private String elementNumber;
	@Column(name="distance_from_reference_point")
	private String distanceFromReferencePoint;
	@Column(name="indication_lemgth")
	private String indicationLength;
	@Column(name="imperfection_symbol")
	private String imperfectionSymbol;
	@Column(name="results_of_examination")
	private ExaminationResult result;
	@Column(name="remarks")
	private String remarks;
	@ManyToOne
	@JoinColumn(name="id_results_of_exmination")
	private Report report;
	
	public ResultsOfExamination() {
		super();
	}
	
	public ResultsOfExamination(Long id, String elementNumber, String distanceFromReferencePoint, String  indicationLength, String imperfectionSymbol,
			ExaminationResult result, String remarks, Report report) {
		super();
		this.id = id;
		this.elementNumber = elementNumber;
		this.distanceFromReferencePoint = distanceFromReferencePoint;
		this.indicationLength = indicationLength;
		this.imperfectionSymbol = imperfectionSymbol;
		this.result = result;
		this.remarks = remarks;
		this.report = report;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	
	
	
	
	
	
}
