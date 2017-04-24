package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MTReport extends Report{
	@Column(name="cleaner_name")
	private String cleanerName;
	@Column(name="cleaner_bath")
	private String cleanerBath;
	@Column(name="white_contrast_name")
	private String whiteContrastName;
	@Column(name="white_contrast_bath")
	private String whiteContrastBath;
	@Column(name="black_powder_name")
	private String blackPowderName;
	@Column(name="black_powder_bath")
	private String blackPowderBath;
	@Column(name="fluoroscent_powder_name")
	private String fuorescentPowderName;
	@Column(name="fluoroscent_powder_batch")
	private String fluoroscentPowderBatch;
	@Column(name="black_light_incensity")
	private Integer blackLightIncensity;
	@Column(name="flield_strength")
	private Double fieldStrength;
	@Column(name="magnetization")
	private String magnetization;
	@Column(name="acceptanceLevel")
	private String acceptanceLevel;

	public MTReport() {
		super();
	}
	public String getCleanerName() {
		return cleanerName;
	}
	public void setCleanerName(String cleanerName) {
		this.cleanerName = cleanerName;
	}
	public String getCleanerBath() {
		return cleanerBath;
	}
	public void setCleanerBath(String cleanerBath) {
		this.cleanerBath = cleanerBath;
	}
	public String getWhiteContrastName() {
		return whiteContrastName;
	}
	public void setWhiteContrastName(String whiteContrastName) {
		this.whiteContrastName = whiteContrastName;
	}
	public String getWhiteContrastBath() {
		return whiteContrastBath;
	}
	public void setWhiteContrastBath(String whiteContrastBath) {
		this.whiteContrastBath = whiteContrastBath;
	}
	public String getBlackPowderName() {
		return blackPowderName;
	}
	public void setBlackPowderName(String blackPowderName) {
		this.blackPowderName = blackPowderName;
	}
	public String getBlackPowderBath() {
		return blackPowderBath;
	}
	public void setBlackPowderBath(String blackPowderBath) {
		this.blackPowderBath = blackPowderBath;
	}
	public String getFuorescentPowderName() {
		return fuorescentPowderName;
	}
	public void setFuorescentPowderName(String fuorescentPowderName) {
		this.fuorescentPowderName = fuorescentPowderName;
	}
	public String getFluoroscentPowderBatch() {
		return fluoroscentPowderBatch;
	}
	public void setFluoroscentPowderBatch(String fluoroscentPowderBatch) {
		this.fluoroscentPowderBatch = fluoroscentPowderBatch;
	}
	public Integer getBlackLightIncensity() {
		return blackLightIncensity;
	}
	public void setBlackLightIncensity(Integer blackLightIncensity) {
		this.blackLightIncensity = blackLightIncensity;
	}
	public Double getFieldStrength() {
		return fieldStrength;
	}
	public void setFieldStrength(Double fieldStrength) {
		this.fieldStrength = fieldStrength;
	}
	public String getMagnetization() {
		return magnetization;
	}
	public void setMagnetization(String magnetization) {
		this.magnetization = magnetization;
	}
	
	

}
