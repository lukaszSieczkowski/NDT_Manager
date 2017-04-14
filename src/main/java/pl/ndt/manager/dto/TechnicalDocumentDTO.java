package pl.ndt.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.TypeOfTesting;

public class TechnicalDocumentDTO extends DocumentDTO{
	@NotBlank(message = "This field may not be empty")
	@Size(max = 200, message = "To long sentence. Only 200 signs allowed")
	private String title;
	@NotBlank(message = "This field may not be empty")
	@Size(max = 50, message = "To long sentence. Only 50 signs allowed")
	private String number;
	@NotNull(message = "Select NDT Method")
	private TypeOfTesting typeOfTesting;
	
	
	public TechnicalDocumentDTO() {
		super();
	
	}

	public TechnicalDocumentDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory,String title,
			String number,TypeOfTesting typeOfTesting) {
		super(id, issueDate, issuedBy, file, fileDirectory);
		this.title = title;
		this.number = number;
		this.typeOfTesting = typeOfTesting;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}

	@Override
	public String toString() {
		return "TechnicalDocumentDTO [title=" + title + ", number=" + number + ", ndtMethod=" + typeOfTesting + ", id=" + id
				+ ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", file=" + file + ", fileDirectory="
				+ fileDirectory + "]";
	}
	
}
