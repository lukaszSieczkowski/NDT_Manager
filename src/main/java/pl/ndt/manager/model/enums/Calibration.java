package pl.ndt.manager.model.enums;

public enum Calibration {
	CB1("Calibration Block no.1"),CB2("Calibration Block no.2");
	
	private String value;

	private Calibration(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	
}
