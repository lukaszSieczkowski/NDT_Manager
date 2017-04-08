package pl.ndt.manager.model.enums;

public enum CorerctlyEyeCondition {
	POSIVE("Positive eye condition"),NEGATIVE("Negative eye condition");
	
	private String value;
	
	private CorerctlyEyeCondition(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}


}
