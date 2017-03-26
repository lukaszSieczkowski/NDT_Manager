package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import pl.ndt.manager.model.enums.NdtMethods;

@Entity
public class NdtCertificate extends Document{

	@Column(name="document_number")
	private String documentNumber;
	@Column(name="sector")
	private String sector;
	@Column(name="ndt_method")
	@Enumerated
	private NdtMethods ndtMethod;
	
	public NdtCertificate() {
		super();
	}
	
	
}
