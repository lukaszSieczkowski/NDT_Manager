package pl.ndt.manager.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import pl.ndt.manager.dto.ReportDTO;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReportsList {

	private List<ReportDTO> reports;
	private ReportDTO reportDTO;
	
	public ReportsList() {
		reports = new ArrayList<>();
	}

	public List<ReportDTO> getReports() {
		return reports;
	}

	public void setReports(List<ReportDTO> reports) {
		this.reports = reports;
	}

	public ReportDTO getReportDTO() {
		return reportDTO;
	}

	public void setReportDTO(ReportDTO reportDTO) {
		this.reportDTO = reportDTO;
	}

	
}
