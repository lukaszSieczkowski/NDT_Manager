package pl.ndt.manager.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import pl.ndt.manager.model.enums.TypeOfControl;

public class VerificationDTO {

	private Long id;
	@NotBlank(message = "This field may not be empty")
	@Size(max = 10, min = 10, message = "Incorect date format")
	private String dateOfVerification;
	@NotNull(message = "Select type of control ")
	private TypeOfControl typeOfControl;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	private String certificateNumber;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	private String doneBy;
	private MeasuringEquipmentDTO measuringEquipmentDTO;
	
	public VerificationDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateOfVerification() {
		return dateOfVerification;
	}
	public void setDateOfVerification(String dateOfVerification) {
		this.dateOfVerification = dateOfVerification;
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
	public MeasuringEquipmentDTO getMeasuringEquipmentDTO() {
		return measuringEquipmentDTO;
	}
	public void setMeasuringEquipmentDTO(MeasuringEquipmentDTO measuringEquipmentDTO) {
		this.measuringEquipmentDTO = measuringEquipmentDTO;
	}
	public String getDoneBy() {
		return doneBy;
	}
	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}
	@Override
	public String toString() {
		return "VerificationDTO [id=" + id + ", dateOfVerification=" + dateOfVerification + ", typeOfControl="
				+ typeOfControl + ", certificateNumber=" + certificateNumber + ", measuringEquipmentDTO="
				+ measuringEquipmentDTO + ", doneBy=" + doneBy + "]";
	}
	
}
