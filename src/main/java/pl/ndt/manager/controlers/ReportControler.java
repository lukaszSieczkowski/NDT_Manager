package pl.ndt.manager.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.ReportsList;
import pl.ndt.manager.dto.ReportDTO;
import pl.ndt.manager.services.ReportService;

@Controller
public class ReportControler {

	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportsList reportsList;
	
	/**
	 * Shows list of all Reports saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showAllReports view
	 */
	@RequestMapping("/showReports")
	private String showAllReports(Model model) {

		List<ReportDTO> reports = reportService.getAllReports();
		reportsList.setReports(reports);
		model.addAttribute("reports", reportsList);

		return "reports/show_reports/showAllReports";
	}
}
