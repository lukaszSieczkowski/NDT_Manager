package pl.ndt.manager.model.enums;

public enum NdtMethods {

	VT_1("Visual Testing Level 1"), VT_2("Visual Testing Level 2"), VT_3("Visual Testing Level 3"),

	PT_1("Penetrant Testing Level 1"), PT_2("Penetrant Testing Level 2"), PT_3("Penetrant Testing Level 3"),

	MT_1("Magnetic Testing Level 1"), MT_2("Magnetic Testing Level 2"), MT_3("Magnetic Testing Level 3"),

	UT_1("Ultrasonic Testing Level 1"), UT_2("Ultrasonic Testing Level 2"), UT_3("Ultrasonic Testing Level 3"),

	RT_1("Radiographic Testing Level 1"), RT_2("Radiographic Testing Level 2"), RT_3("Radiographic Testing Level 3"),

	PA_1("Phased Array Testing Level 1"), PA_2("Phased Array Testing Level 2"), PA_3("Phased Array Testing Level 3"),

	ET_1("Eddy Current Testing Level 1"), ET_2("Eddy Current Testing Level 2"), ET_3("Eddy Current Testing Level 3"),

	TOFD_1("Time of Flight Diffraction Level 1"), TOFD_2("Time of Flight Diffraction Level 2"), TOFD_3(
			"Time of Flight Diffraction Level 3");

	private String value;

	private NdtMethods(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
