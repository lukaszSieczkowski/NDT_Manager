package pl.ndt.manager.model.enums;

public enum QualityLevel {
	B("B"), C("C"), D("D");

	private String value;

	private QualityLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
