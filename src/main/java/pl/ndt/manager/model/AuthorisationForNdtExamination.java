package pl.ndt.manager.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import pl.ndt.manager.model.enums.NdtMethods;

@Entity
public class AuthorisationForNdtExamination extends Document {

	@Column(name = "ndt_methods")
	@ElementCollection(targetClass = NdtMethods.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "ndt_methods")
	private Collection<NdtMethods> ndtMethodsList;

	public AuthorisationForNdtExamination() {

	}

}
