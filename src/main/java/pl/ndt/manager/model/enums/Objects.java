package pl.ndt.manager.model.enums;

public enum Objects {

	CHEMICALS("Chemicals"), CUSTOMER("Customer"), DEVICE("Device"), PROBE("Probe"), VERIFICATION("Verification");

	private String value;

	private Objects(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
