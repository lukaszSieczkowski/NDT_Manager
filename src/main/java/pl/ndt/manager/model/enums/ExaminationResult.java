package pl.ndt.manager.model.enums;

public enum ExaminationResult {
	OK("Accepted"), NOK("Not Accepted");

	private String value;

	private ExaminationResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
