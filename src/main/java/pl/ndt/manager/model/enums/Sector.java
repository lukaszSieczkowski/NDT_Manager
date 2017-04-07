package pl.ndt.manager.model.enums;

public enum Sector {
	CASTINGS("1 - Castings"), FORGINGS("2 - Forgings"), WELDED_PRODUCTS("3 - Welded Products"),

	TUBES("4 - Tubes and Pipes"), WROUGHT("5 - Wrought Products"), METAL_MANUFACTURING("6 - Metal Manufacturing"),

	PRE_AND_IN_SERVICE("7 - Pre and In-Service"), RAILWAY("8 - Railway"),

	AREOSPACE("9 - Areosapce"), METL_PRE_AND_IN_SERVICE("6,7 - Metal Manufacturing, Pre and In-Service");

	private String value;

	private Sector(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
