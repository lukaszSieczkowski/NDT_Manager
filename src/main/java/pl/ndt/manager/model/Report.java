package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.Client;

import pl.ndt.manager.model.enums.QualityLevel;
import pl.ndt.manager.model.enums.TypeOfTesting;

@Entity
@Table(name = "report")
@PrimaryKeyJoinColumn(name = "documnet_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Report extends Document {

	@ManyToOne
	@JoinColumn(name="id_client")
	private Customer customer;
	@Column(name="report_number")
	private String reportNumber;
	@Column(name="place")
	private String place;
	@Column(name="order_number")
	private String orderNumber;
	@Column(name="examinated_object")
	private String examinatedObject;
	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MeasuringEquipment> measuringEquipmentList;
	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TechnicalDocument> technicalDocumentList;
	@Column(name="examination_date")
	private LocalDateTime examinationDate;
	@Column(name="quality_level")
	private QualityLevel qualityLevel;
	@ManyToOne
	@JoinColumn(name="id_employe_performer")	
	private Employee performer;
	@ManyToOne
	@JoinColumn(name="id_employe_approver")
	private Employee aprover;

	
	@OneToMany(mappedBy="report",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ResultsOfExamination> resultsOfExaminationtsList;
	
	public Report() {
		super();
	}

	public Report(long id, LocalDateTime issueDate, String issuedBy, String fileName,Customer customer,String reportNumber,
			String place,String orderNumber,String examinatedObject,List<MeasuringEquipment> measuringEquipmentList,
			List<TechnicalDocument> technicalDocumentList,LocalDateTime examinationDate,Employee performer,Employee aprover,
			List<ResultsOfExamination> resultsOfExaminationtsList) {
		super(id, issueDate, issuedBy, fileName);
		this.customer=customer;
		this.reportNumber = reportNumber;
		this.place = place;
		this.orderNumber = orderNumber;
		this.examinatedObject = examinatedObject;
		this.measuringEquipmentList = measuringEquipmentList;
		this.technicalDocumentList = technicalDocumentList;
		this.examinationDate = examinationDate;
		this.performer = performer;
		this.aprover = aprover;
		this.resultsOfExaminationtsList = resultsOfExaminationtsList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
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


	public List<MeasuringEquipment> getMeasuringEquipmentList() {
		return measuringEquipmentList;
	}

	public void setMeasuringEquipmentList(List<MeasuringEquipment> measuringEquipmentList) {
		this.measuringEquipmentList = measuringEquipmentList;
	}

	public List<TechnicalDocument> getTechnicalDocumentList() {
		return technicalDocumentList;
	}

	public void setTechnicalDocumentList(List<TechnicalDocument> technicalDocumentList) {
		this.technicalDocumentList = technicalDocumentList;
	}

	public LocalDateTime getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(LocalDateTime examinationDate) {
		this.examinationDate = examinationDate;
	}

	public Employee getPerformer() {
		return performer;
	}

	public void setPerformer(Employee performer) {
		this.performer = performer;
	}

	public Employee getAprover() {
		return aprover;
	}

	public void setAprover(Employee aprover) {
		this.aprover = aprover;
	}


	public List<ResultsOfExamination> getResultsOfExaminationtsList() {
		return resultsOfExaminationtsList;
	}

	public void setResultsOfExaminationtsList(List<ResultsOfExamination> resultsOfExaminationtsList) {
		this.resultsOfExaminationtsList = resultsOfExaminationtsList;
	}

	public QualityLevel getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(QualityLevel qualityLevel) {
		this.qualityLevel = qualityLevel;
	}
	

}
