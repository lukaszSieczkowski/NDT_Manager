package pl.ndt.manager.model.enums;

public enum TypeOfControl {

	CHECK("Check"),CALIBRATION("Calibration");
	
	private String value;
	
	private TypeOfControl(String value){
		this.value =value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
