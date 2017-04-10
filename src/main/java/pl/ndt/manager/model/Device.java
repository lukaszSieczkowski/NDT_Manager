package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.TypeOfTesting;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "devices")
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(name = "name")
	protected String name;
	@Column(name = "producer")
	protected String producer;
	@Column(name = "production_year")
	protected Integer productionYear;
	@Column(name = "model")
	protected String model;
	@Column(name = "serial_number")
	protected String serialNumber;
	@Column(name = "start_of_use")
	protected LocalDateTime startOfUse;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "device_id")
	protected Location location;
	
	public Device() {
		super();
	}
	
	

	public Device(Long id, String name, String producer, Integer productionYear, String model, String serialNumber,
			LocalDateTime startOfUse, Location location) {
		super();
		this.id = id;
		this.name = name;
		this.producer = producer;
		this.productionYear = productionYear;
		this.model = model;
		this.serialNumber = serialNumber;
		this.startOfUse = startOfUse;
		this.location = location;
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

	public LocalDateTime getStartOfUse() {
		return startOfUse;
	}

	public void setStartOfUse(LocalDateTime startOfUse) {
		this.startOfUse = startOfUse;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	
	
}
