package pl.ndt.manager.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerDTO {
	private long id;
	@Size(max = 60, message="To long sentence. Only 60 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String customerName;
	@Size(max = 40, message="To long sentence. Only 40 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String street;
	@DecimalMax(value = "999999",message="Incorrect value")
	@NotBlank(message = "This field may not be empty")
	private String houseNumber;
	@DecimalMax(value = "999999",message="Incorrect value")
	@NotBlank(message = "This field may not be empty")
	private String localNumber;
	@Size(max = 40, message="To long sentence. Only 40 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String city;
	@Size(max = 10, message="To long sentence. Only 10 signs allowed")
	@NotBlank(message = "This field may not be empty")
	private String zipCode;
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(long id, String customerName, String street, String houseNumber, String localNumber,
			String city, String zipCode) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocalNumber() {
		return localNumber;
	}
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", institutionName=" + customerName + ", street=" + street
				+ ", houseNumber=" + houseNumber + ", localNumber=" + localNumber + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}
	
	
}
