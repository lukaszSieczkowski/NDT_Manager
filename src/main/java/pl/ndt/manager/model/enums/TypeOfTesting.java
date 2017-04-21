package pl.ndt.manager.model.enums;

public enum TypeOfTesting {
	
	VT("Visual Testig"),PT("Penetrant Testing"),UT("Ultrasonic Testing"),RT("Radiographic Testing"),MT("Magnetic Testing");

	
	private String value;
	
	private TypeOfTesting(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	
	
	

}
