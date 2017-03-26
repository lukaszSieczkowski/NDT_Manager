package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="document")
public abstract class Document {
	
	@Id
	@GeneratedValue
	@Column(name="id_document")
	private long id;
	@Column(name="issue_date")
	private LocalDateTime issueDate;
	@Column(name="expiration_date")
	private LocalDateTime  expirationDate;
	@Column(name="issued_by")
	private String issuedBy;
	@Column(name="file_name")
	private String fileName;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Document() {
		
	}
	
	
}
