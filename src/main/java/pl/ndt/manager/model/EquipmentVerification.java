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
public class EquipmentVerification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_of_verification")
	private LocalDateTime dateOfVerification;
	@Column(name = "final_date_verification")
	private LocalDateTime finalDateOfVerification;
	@Column(name = "type_of_control")
	private TypeOfControl typeOfControl;
	@Column(name = "certificate_number")
	private String certificateNumber;
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Device device;
	public EquipmentVerification() {
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

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	
}
