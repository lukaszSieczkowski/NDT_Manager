package pl.ndt.manager.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class DocumentDTO {
	protected long id;
	@NotBlank(message = "This field may not be empty")
	@Size(max = 10, min = 10, message = "Incorect date format")
	protected String issueDate;

	@NotBlank(message = "This field may not be empty")
	@Size(max = 50, message = "To long sentence. Only 50 signs allowed")
	protected String issuedBy;

	protected MultipartFile file;
	protected String fileDirectory;

	public DocumentDTO() {
		super();
	}

	public DocumentDTO(long id, String issueDate, String issuedBy, MultipartFile file, String fileDirectory) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.issuedBy = issuedBy;
		this.file = file;
		this.fileDirectory = fileDirectory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	@Override
	public String toString() {
		return "DocumentDTO [id=" + id + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", file=" + file
				+ ", fileDirectory=" + fileDirectory + "]";
	}

}
