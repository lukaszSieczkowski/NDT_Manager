package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class PTReport extends Report {
	@Column(name="cleaner_name")
	private String cleanerName;
	@Column(name="cleaner_bath")
	private String cleanerBath;
	@Column(name="color_penetrant_name")
	private String colorPenetrantName;
	@Column(name="color_penetrant_bath")
	private String colorPenetrantBath;
	@Column(name="fluoroscent_penetrant_name")
	private String fluoroscentPenetrantName;
	@Column(name="fluoroscent_penetrant_bath")
	private String fluoroscentPenetrantBath;
	@Column(name="developer_name")
	private String developerName;
	@Column(name="developer_bath")
	private String developerBath;
	@Column(name="black_light_incensity")
	private Integer blackLightIncensity;
	@Column(name="examination_system")
	private String examinationSystem;
	@Column(name="penetration_time")
	private Integer penetrationTime;
	@Column(name="developing_time")
	private Integer developingTime;
	
	public PTReport() {
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

	public String getColorPenetrantName() {
		return colorPenetrantName;
	}

	public void setColorPenetrantName(String colorPenetrantName) {
		this.colorPenetrantName = colorPenetrantName;
	}

	public String getColorPenetrantBath() {
		return colorPenetrantBath;
	}

	public void setColorPenetrantBath(String colorPenetrantBath) {
		this.colorPenetrantBath = colorPenetrantBath;
	}

	public String getFluoroscentPenetrantName() {
		return fluoroscentPenetrantName;
	}

	public void setFluoroscentPenetrantName(String fluoroscentPenetrantName) {
		this.fluoroscentPenetrantName = fluoroscentPenetrantName;
	}

	public String getFluoroscentPenetrantBath() {
		return fluoroscentPenetrantBath;
	}

	public void setFluoroscentPenetrantBath(String fluoroscentPenetrantBath) {
		this.fluoroscentPenetrantBath = fluoroscentPenetrantBath;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getDeveloperBath() {
		return developerBath;
	}

	public void setDeveloperBath(String developerBath) {
		this.developerBath = developerBath;
	}

	public Integer getBlackLightIncensity() {
		return blackLightIncensity;
	}

	public void setBlackLightIncensity(Integer blackLightIncensity) {
		this.blackLightIncensity = blackLightIncensity;
	}

	public String getExaminationSystem() {
		return examinationSystem;
	}

	public void setExaminationSystem(String examinationSystem) {
		this.examinationSystem = examinationSystem;
	}

	public Integer getPenetrationTime() {
		return penetrationTime;
	}

	public void setPenetrationTime(Integer penetrationTime) {
		this.penetrationTime = penetrationTime;
	}

	public Integer getDevelopingTime() {
		return developingTime;
	}

	public void setDevelopingTime(Integer developingTime) {
		this.developingTime = developingTime;
	}
	
	
}
