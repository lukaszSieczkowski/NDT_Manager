package pl.ndt.manager.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.enums.TypeOfTesting;

public class DeviceDTO {
	
	protected Long id;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	protected String name;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	protected String producer;
	@NotBlank(message = "Select production year ")
	protected String productionYear;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	protected String model;
	@NotBlank(message = "This field may not be empty")
	@Size(max=30, message="To long sentence. Only 30 signs allowed")
	protected String serialNumber;
	@NotBlank(message = "This field may not be empty")
	@Size(max = 10, min = 10, message = "Incorect date format")
	protected String startOfUse;
	@NotEmpty(message = "Select location")
	private String locationName;
	@NotNull(message = "Select type of testing ")
	protected TypeOfTesting typeOfTesting;
	
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

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}
	
	

}

