package pl.ndt.manager.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.ndt.manager.model.enums.Calibration;

@Entity
public class UTReport extends Report{
	
	@ManyToOne
	@JoinColumn(name="report_id" )
	private Probe probe;
	@Column(name="possition")
	private String position;
	@Column(name="calibration")
	private Calibration calibration;
	@Column(name="registration_level")
	private String registrationLevel;
	@Column(name="registration_limit")
	private String registrationLimit;
	@Column(name="calibration_range")
	private String calibrationRange;
	@Column(name="enhancement")
	private Double enhancement;
	@Column(name="transfer_loos")
	private Double transferLoos;
	@Column(name="registration_enthancement")
	private Double registrationEnthancment;
	
	
	public UTReport() {
		super();
	}
	
	public Probe getProbe() {
		return probe;
	}
	public void setProbe(Probe probe) {
		this.probe = probe;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Calibration getCalibration() {
		return calibration;
	}
	public void setCalibration(Calibration calibration) {
		this.calibration = calibration;
	}
	public String getRegistrationLevel() {
		return registrationLevel;
	}
	public void setRegistrationLevel(String registrationLevel) {
		this.registrationLevel = registrationLevel;
	}
	public String getRegistrationLimit() {
		return registrationLimit;
	}
	public void setRegistrationLimit(String registrationLimit) {
		this.registrationLimit = registrationLimit;
	}
	public String getCalibrationRange() {
		return calibrationRange;
	}
	public void setCalibrationRange(String calibrationRange) {
		this.calibrationRange = calibrationRange;
	}
	public Double getEnhancement() {
		return enhancement;
	}
	public void setEnhancement(Double enhancement) {
		this.enhancement = enhancement;
	}
	public Double getTransferLoos() {
		return transferLoos;
	}
	public void setTransferLoos(Double transferLoos) {
		this.transferLoos = transferLoos;
	}
	public Double getRegistrationEnthancment() {
		return registrationEnthancment;
	}
	public void setRegistrationEnthancment(Double registrationEnthancment) {
		this.registrationEnthancment = registrationEnthancment;
	}
	
}
