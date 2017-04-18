package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "vt_report")
@PrimaryKeyJoinColumn(name = "report_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class VTReport extends Report {
	
	@Column(name = "lighting")
	private Integer lighting;
	

	public VTReport() {

	}


	public VTReport(long id, LocalDateTime issueDate, String issuedBy, String fileName, Customer customer,
			String reportNumber, String place, String orderNumber, String examinatedObject,
			List<MeasuringEquipment> measuringEquipmentList, List<TechnicalDocument> technicalDocumentList,
			LocalDateTime examinationDate, Employee performer, Employee aprover,
			List<ResultsOfExamination> resultsOfExaminationtsList,Integer lighting) {
		super(id, issueDate, issuedBy, fileName, customer, reportNumber, place, orderNumber, examinatedObject,
				measuringEquipmentList, technicalDocumentList, examinationDate, performer, aprover, resultsOfExaminationtsList);
		this.lighting = lighting;
	}


	public Integer getLighting() {
		return lighting;
	}


	public void setLighting(Integer lighting) {
		this.lighting = lighting;
	}

	

	
}
