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



@Entity
@Table(name = "probes")
@PrimaryKeyJoinColumn(name = "device_id")
public class Probe extends Device {

	@Column(name = "frequency")
	private Double frequency;
	@Column(name = "angle")
	private Integer angle;
	@OneToMany(mappedBy="probe",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <UTReport> reports;
	public Probe() {
		super();
	}

	public Double getFrequency() {
		return frequency;
	}

	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}

	public Integer getAngle() {
		return angle;
	}

	public void setAngle(Integer angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "Probe [frequency=" + frequency + ", angle=" + angle + ", id=" + id + ", name=" + name + ", producer="
				+ producer + ", productionYear=" + productionYear + ", model=" + model + ", serialNumber="
				+ serialNumber + ", startOfUse=" + startOfUse + ", location=" + location + ", typeOfTesting="
				+ typeOfTesting + "]";
	}

}
