package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.TypeOfTesting;
@Entity
@Table(name="measuring_equipment")
@PrimaryKeyJoinColumn(name = "device_id")
public class MeasuringEquipment extends Device {
	@Column(name = "device_code",length=30)
	private String deviceCode;
	@Column(name = "frequency_of_verification")
	private Integer ferquencyOfVerification;
	@OneToMany(mappedBy = "measuringEquipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Verification> equipmentVerificationList;
	
	public MeasuringEquipment() {
		super();
	}

	
	public MeasuringEquipment(Long id, String name, String producer, Integer productionYear, String model,
			String serialNumber, LocalDateTime startOfUse, Location location,TypeOfTesting typeOfTesting, String deviceCode,
			Integer ferquencyOfVerification,List<Verification> equipmentVerificationList) {
		super(id, name, producer, productionYear, model, serialNumber, startOfUse, location,typeOfTesting);
		this.deviceCode = deviceCode;
		this.ferquencyOfVerification = ferquencyOfVerification;
		
		this.equipmentVerificationList = equipmentVerificationList;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public Integer getFerquencyOfVerification() {
		return ferquencyOfVerification;
	}

	public void setFerquencyOfVerification(Integer ferquencyOfVerification) {
		this.ferquencyOfVerification = ferquencyOfVerification;
	}

	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}
	

	public List<Verification> getEquipmentVerificationList() {
		return equipmentVerificationList;
	}


	public void setEquipmentVerificationList(List<Verification> equipmentVerificationList) {
		this.equipmentVerificationList = equipmentVerificationList;
	}



}
