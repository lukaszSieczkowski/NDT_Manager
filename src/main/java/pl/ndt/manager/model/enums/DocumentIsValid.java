package pl.ndt.manager.model.enums;

public enum DocumentIsValid {
	VALID("Valid"), EXPIRED("Expired");

	private String value;

	private DocumentIsValid(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
