package pl.ndt.manager.dto;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

public class ProbeDTO extends DeviceDTO {

	@Digits(fraction = 1, integer = 2,message="Incorect number format")
	private String frequency;
	@NotEmpty(message = "Select angle")
	private String angle;
	

	public ProbeDTO() {
		super();
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getAngle() {
		return angle;
	}
	
	public void setAngle(String angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "ProbeDTO [frequency=" + frequency + ", angle=" + angle + ", id=" + id + ", name=" + name + ", producer="
				+ producer + ", productionYear=" + productionYear + ", model=" + model + ", serialNumber="
				+ serialNumber + ", startOfUse=" + startOfUse + ", typeOfTesting=" + typeOfTesting + "]";
	}

	

}
