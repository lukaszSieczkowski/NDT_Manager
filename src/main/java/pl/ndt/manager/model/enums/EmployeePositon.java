package pl.ndt.manager.model.enums;

public enum EmployeePositon {
	NDT_INSPECTOR("NDT Manager"), NDT_MANAGER("NDT Inspector");

	private String value;

	private EmployeePositon(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
