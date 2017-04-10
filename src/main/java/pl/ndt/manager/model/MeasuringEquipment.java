package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.TypeOfTesting;
@Entity
@Table(name="measuring_equipments")
@PrimaryKeyJoinColumn(name = "device_id")
public class MeasuringEquipment extends Device {
	@Column(name = "device_code")
	private String deviceCode;
	@Column(name = "frequency_of_verification")
	private Integer ferquencyOfVerification;
	@ElementCollection(targetClass = TypeOfTesting.class)
	@CollectionTable(name = "types_of_testing")
	@Column(name = "type")
	private List<TypeOfTesting> typeOfTestingList;
	@OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EquipmentVerification> equipmentVerificationList;
	
	public MeasuringEquipment() {
		super();
	}

	
	public MeasuringEquipment(Long id, String name, String producer, Integer productionYear, String model,
			String serialNumber, LocalDateTime startOfUse, Location location, String deviceCode,
			Integer ferquencyOfVerification,List<TypeOfTesting> typeOfTestingList,List<EquipmentVerification> equipmentVerificationList) {
		super(id, name, producer, productionYear, model, serialNumber, startOfUse, location);
		this.deviceCode = deviceCode;
		this.ferquencyOfVerification = ferquencyOfVerification;
		this.typeOfTestingList = typeOfTestingList;
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

	public List<TypeOfTesting> getTypeOfTestingList() {
		return typeOfTestingList;
	}

	public void setTypeOfTestingList(List<TypeOfTesting> typeOfTestingList) {
		this.typeOfTestingList = typeOfTestingList;
	}

	public List<EquipmentVerification> getEquipmentVerificationList() {
		return equipmentVerificationList;
	}

	public void setEquipmentVerificationList(List<EquipmentVerification> equipmentVerificationList) {
		this.equipmentVerificationList = equipmentVerificationList;
	}

	@Override
	public String toString() {
		return "MeasuringEquipment [deviceCode=" + deviceCode + ", ferquencyOfVerification=" + ferquencyOfVerification
				+ ", typeOfTestingList=" + typeOfTestingList + ", equipmentVerificationList="
				+ equipmentVerificationList + ", id=" + id + ", name=" + name + ", producer=" + producer
				+ ", productionYear=" + productionYear + ", model=" + model + ", serialNumber=" + serialNumber
				+ ", startOfUse=" + startOfUse + ", location=" + location + "]";
	}
	
}
