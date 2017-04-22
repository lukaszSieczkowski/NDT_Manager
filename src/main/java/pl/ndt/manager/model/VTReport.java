package pl.ndt.manager.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vt_report")
@PrimaryKeyJoinColumn(name = "report_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class VTReport extends Report {

	@Column(name = "lighting")
	private Integer lighting;

	public VTReport() {

	}

	

	public Integer getLighting() {
		return lighting;
	}

	public void setLighting(Integer lighting) {
		this.lighting = lighting;
	}

}
