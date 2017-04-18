package pl.ndt.manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.ndt.manager.model.enums.ExaminationResult;

@Entity
public class ExainatedObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String objectType;
	private Integer amount;
	private String steelGrade;
	private String heatNumber;
	private String plateNumber;
	private ExaminationResult exainationResult;
	private String remarks;
	
	
	
	

}
