package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.TypeOfControl;

@Entity
@Table(name = "equimnet_verification")
public class Verification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_of_verification")
	private LocalDateTime dateOfVerification;
	@Column(name = "final_date_verification")
	private LocalDateTime finalDateOfVerification;
	@Column(name = "type_of_control")
	private TypeOfControl typeOfControl;
	@Column(name = "certificate_number",length=30)
	private String certificateNumber;
	@Column(name="done_by",length=30)
	private String doneBy;
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private MeasuringEquipment measuringEquipment;
	
	public Verification() {
		super();
	}

	public LocalDateTime getDateOfVerification() {
		return dateOfVerification;
	}

	public void setDateOfVerification(LocalDateTime dateOfVerification) {
		this.dateOfVerification = dateOfVerification;
	}

	public LocalDateTime getFinalDateOfVerification() {
		return finalDateOfVerification;
	}

	public void setFinalDateOfVerification(LocalDateTime finalDateOfVerification) {
		this.finalDateOfVerification = finalDateOfVerification;
	}

	public TypeOfControl getTypeOfControl() {
		return typeOfControl;
	}

	public void setTypeOfControl(TypeOfControl typeOfControl) {
		this.typeOfControl = typeOfControl;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getDoneBy() {
		return doneBy;
	}

	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}

	public MeasuringEquipment getMeasuringEquipment() {
		return measuringEquipment;
	}

	public void setMeasuringEquipment(MeasuringEquipment measuringEquipment) {
		this.measuringEquipment = measuringEquipment;
	}
	

	
}
