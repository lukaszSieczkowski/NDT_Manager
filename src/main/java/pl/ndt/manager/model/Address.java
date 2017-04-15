package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="street",length=40)
	private String street;
	@Column(name="house_number")
	private Integer houseNumber;
	@Column(name="local_number")
	private Integer localNumber;
	@Column(name="city",length=40)
	private String city;
	@Column(name="zip_code",length=10)
	private String zipCode;
	@OneToOne(mappedBy="address")
	private Location locaton;
	@OneToOne(mappedBy="address")
	private Customer customer;
	
	public Address() {
		super();
	}
	
	public Address(Long id, String street, Integer houseNumber, Integer localNumber, String city, String zipCode,
			Location locaton) {
		super();
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.city = city;
		this.zipCode = zipCode;
		this.locaton = locaton;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(Integer localNumber) {
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

	public Location getLocaton() {
		return locaton;
	}

	public void setLocaton(Location locaton) {
		this.locaton = locaton;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", houseNumber=" + houseNumber + ", localNumber="
				+ localNumber + ", city=" + city + ", zipCode=" + zipCode + ", locaton=" + locaton + "]";
	}

	
	
}
