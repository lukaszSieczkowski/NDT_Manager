package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MeasuringEquipmentDTO extends DeviceDTO {
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	private String deviceCode;
	@NotNull(message = "Select period")
	private Integer validityPeriod;

	public MeasuringEquipmentDTO() {
		super();
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	@Override
	public String toString() {
		return "MeasuringEquipmentDTO [deviceCode=" + deviceCode + ", validityPeriod=" + validityPeriod + ", id=" + id
				+ ", name=" + name + ", producer=" + producer + ", productionYear=" + productionYear + ", model="
				+ model + ", serialNumber=" + serialNumber + ", startOfUse=" + startOfUse + ", typeOfTesting="
				+ typeOfTesting + "]";
	}
	
	

}
