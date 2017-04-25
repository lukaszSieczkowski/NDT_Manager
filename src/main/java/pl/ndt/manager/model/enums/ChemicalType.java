package pl.ndt.manager.model.enums;

public enum ChemicalType {
	CLEANER("Cleaner"), WHITE_CONTRAST("White Contrast"), BLACK_POWDER("Black Powder"),
			FLUORSCENT_POWDER("Fluoroscent Powder"), COLOR_PENETRANT("Color Penetrant"),
			FLUROSCENT_PENETRANT("Fluoroscent Penetrant"),
			COLOR_FLUOROSCENT_PENETRANT("Color-Fluoroscent Penetrant");

	private String value;
	
	private ChemicalType(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	
	
}
