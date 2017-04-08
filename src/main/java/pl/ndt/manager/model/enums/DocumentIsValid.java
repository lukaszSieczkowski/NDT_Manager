package pl.ndt.manager.model.enums;

public enum DocumentIsValid {
	VALID("Valid"), SIXTY_DAYS("Valid less than 60 days"),THIRTY_DAYS("Valid less than 30 days"),EXPIRED("Expired");

	private String value;

	private DocumentIsValid(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
