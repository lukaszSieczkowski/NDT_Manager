package pl.ndt.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VcaCertificate extends Document{

	@Column(name="document_number")
	private String documentNumber;
	
	public VcaCertificate(){
		
	}
}
