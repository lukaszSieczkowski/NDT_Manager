package pl.ndt.manager.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class DeviceDTO {
	
	protected Long id;
	protected String name;
	protected String producer;
	protected Integer productionYear;
	protected String model;
	protected String serialNumber;
	protected String startOfUse;
	
	public DeviceDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getStartOfUse() {
		return startOfUse;
	}

	public void setStartOfUse(String startOfUse) {
		this.startOfUse = startOfUse;
	}

	@Override
	public String toString() {
		return "DeviceDTO [id=" + ", name=" + name + ", producer=" + producer
				+ ", productionYear=" + productionYear + ", model=" + model + ", serialNumber=" + serialNumber
				+ ", startOfUse=" + startOfUse + "]";
	}
	
	
}
