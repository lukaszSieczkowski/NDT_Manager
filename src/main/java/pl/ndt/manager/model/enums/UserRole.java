package pl.ndt.manager.model.enums;

public enum UserRole {

	USER("User"), ADMIN("Administrator");
	
	private String value;
	
	private UserRole(String value){
		this.value= value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
