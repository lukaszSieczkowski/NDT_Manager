package pl.ndt.manager.controlers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import pl.ndt.manager.components.*;

import pl.ndt.manager.dto.*;

import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.services.*;

@Controller
public class ReportControler {

	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportsList reportsList;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomersList customersList;
	@Autowired
	private DevicesList devicesList;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private DocumentList documentList;
	@Autowired
	private EmployeeList employeeList;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ResultsList resultsList;
	@Autowired
	private AlertComponent AlertComponent;
	
	/**
	 * Shows list of all Reports saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showAllReports view
	 */
	@GetMapping("/showReports")
	private String showAllReports(Model model) {

		List<ReportDTO> reports = reportService.getAllReports();
		reportsList.setReports(reports);
		model.addAttribute("reports", reportsList);

		return "reports/show_reports/showAllReports";
	}

	@GetMapping("/addReport")
	private String addReport(Model model) {
		List<CustomerDTO> customers = customerService.getCustomers();
		customersList.setCustomers(customers);

		List<DeviceDTO> devices = deviceService.getMeasuringEqupiment();
		devicesList.setDevices(devices);

		List<DocumentDTO> documents = documentService.getTechnicalDocuments();
		documentList.setDocuments(documents);

		ArrayList<EmployeeDTO> employees = (ArrayList<EmployeeDTO>) employeeService.getAllEmployees();
		employeeList.setEmployees(employees);

		model.addAttribute("customers", customersList);
		model.addAttribute("reportGeneralDTO", new ReportGeneralDTO());

		return "reports/add_report/addReport";
	}

	@PostMapping("/addReportDetails")
	private String addReportDetails(@Valid @ModelAttribute ReportGeneralDTO reportGeneralDTO,
			BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			reportsList.setReporGeneralDTO(reportGeneralDTO);

			model.addAttribute("employess", employeeList);
			model.addAttribute("documents", documentList);

			if (reportGeneralDTO.getTypeOfTesting().equals(TypeOfTesting.VT)) {
				deviceService.sortDeviceByMethood(reportGeneralDTO.getTypeOfTesting());
				model.addAttribute("visualReportDetailsDTO", new VisualReportDetailsDTO());
				model.addAttribute("devices", devicesList);
				return "reports/add_report/addVisualReport";
			} else if (reportGeneralDTO.getTypeOfTesting().equals(TypeOfTesting.PT)) {
				return "reports/add_report/addPenetrantReport";
			} else if (reportGeneralDTO.getTypeOfTesting().equals(TypeOfTesting.MT)) {
				return "reports/add_report/addMagneticReport";
			} else if (reportGeneralDTO.getTypeOfTesting().equals(TypeOfTesting.MT)) {
				return "reports/add_report/addUltrasonicReport";
			}
		}

		model.addAttribute("customers", customersList);
		return "reports/add_report/addReport";
	}

	@GetMapping("/addVisualResults")
	public String addVisualResults(@Valid @ModelAttribute VisualReportDetailsDTO visualReportDetailsDTO,
			BindingResult bindingResult, @RequestParam Long id, Model model) {
		System.out.println("B£êdy" + bindingResult.getErrorCount());
		if (!bindingResult.hasErrors()) {
			System.out.println("REPORT" + visualReportDetailsDTO);

			// DTO DTO DTO

			VisualReportDTO visualReportDTO = (VisualReportDTO) reportsList.getReportDTO();
			visualReportDTO.setExaminatedObject(visualReportDetailsDTO.getExaminatedObject());
			visualReportDTO.setTechnicalDocument(visualReportDetailsDTO.getTechnicalDocument());
			visualReportDTO.setMeasuringEquipment(visualReportDetailsDTO.getMeasuringEquipment());
			visualReportDTO.setAprover(visualReportDetailsDTO.getAproverEmail());
			visualReportDTO.setPerformer(String.valueOf(id));
			visualReportDTO.setLighting(visualReportDetailsDTO.getLighting());
			reportsList.setReportDTO(visualReportDTO);

			model.addAttribute("results", resultsList);
			model.addAttribute("resultsOfExaminationDTO", new ResultOfExaminationDTO());
			return "reports/add_report/addVisualResults";

		}
		model.addAttribute("employess", employeeList);
		model.addAttribute("documents", documentList);
		model.addAttribute("devices", devicesList);
		return "reports/add_report/addVisualReport";

	}

	@GetMapping("/addExaminationResult")
	public String addExaminationResult(@ModelAttribute ResultOfExaminationDTO resultOfExaminationDTO, Model model) {
		resultsList.getResults().add(resultOfExaminationDTO);
		model.addAttribute("resultsOfExaminationDTO", new ResultOfExaminationDTO());
		model.addAttribute("results", resultsList);

		return "reports/add_report/addVisualResults";
	}

	@GetMapping("/saveVisualCertificate")
	public String saveReport(@ModelAttribute ResultOfExaminationDTO resultOfExaminationDTO, Model model) {

		reportService.saveVisualReport();
		resultsList.setResults(new ArrayList<>());

		List<ReportDTO> reports = reportService.getAllReports();
		reportsList.setReports(reports);
		model.addAttribute("reports", reportsList);
		return "reports/show_reports/showAllReports";

	}

}
