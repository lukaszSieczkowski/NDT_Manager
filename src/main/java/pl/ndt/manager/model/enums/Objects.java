package pl.ndt.manager.model.enums;

public enum Objects {

	CHEMICALS("Chemicals"), CUSTOMER("Customer"), DEVICE("Device"), PROBE("Probe"), VERIFICATION("Verification"),
	NDT_CERTIFICATE("NDT Certificate"),MEDICAL_EXAMINATION("Medical Examination"),JAEGER_TEST("Jaeger Test"),VCA_CERTIFICATE("VCA Certificate"),
	STANDARD("Standard"),EMPLOYEE("Employee"),LOCATION("Location"),VISUAL_REPORT("Visual Report");
	

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
