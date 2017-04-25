package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pl.ndt.manager.model.enums.ChemicalType;
import pl.ndt.manager.model.enums.TypeOfTesting;

@Entity
public class Chemical {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(max = 40, message="To long sentence. Only 40 signs allowed")
	@NotBlank(message = "This field may not be empty")
	@Column(name="name", length=40)
	private String name;
	@Size(max = 40, message="To long sentence. Only 40 signs allowed")
	@NotBlank(message = "This field may not be empty")
	@Column(name="producer",length=40)
	private String producer;
	@Size(max = 20, message="To long sentence. Only 20 signs allowed")
	@NotBlank(message = "This field may not be empty")
	@Column(name="batch",length=20)
	private String batch;
	@NotNull(message = "Select Chemicals Type")
	@Column(name="chemical_type")
	private ChemicalType chemicalType;
	@NotNull(message = "Select NDT Method")
	@Column(name="type_of_testing")
	private TypeOfTesting typeOfTesting;
	public Chemical() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public ChemicalType getChemicalType() {
		return chemicalType;
	}
	public void setChemicalType(ChemicalType chemicalType) {
		this.chemicalType = chemicalType;
	}
	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}
	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Chemical [id=" + id + ", name=" + name + ", producer=" + producer + ", batch=" + batch
				+ ", chemicalType=" + chemicalType + ", typeOfTesting=" + typeOfTesting + "]";
	}
	
	
}
