package pl.ndt.manager.controlers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.CustomersList;
import pl.ndt.manager.components.DevicesList;
import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.components.ReportsList;
import pl.ndt.manager.components.ResultsList;
import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.EmployeeDTO;
import pl.ndt.manager.dto.EquipmentDTO;
import pl.ndt.manager.dto.ReportDTO;
import pl.ndt.manager.dto.VisualReportDetailsDTO;
import pl.ndt.manager.dto.ReportGeneralDTO;
import pl.ndt.manager.dto.ResultOfExaminationDTO;
import pl.ndt.manager.dto.VisualReportDTO;
import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.services.CustomerService;
import pl.ndt.manager.services.DeviceService;
import pl.ndt.manager.services.DocumentService;
import pl.ndt.manager.services.EmployeeService;
import pl.ndt.manager.services.ReportService;

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

	@RequestMapping("/addReport")
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

	@RequestMapping("/addReportDetails")
	private String addReportDetails(@Valid @ModelAttribute ReportGeneralDTO reportGeneralDTO, BindingResult bindingResult,
			Model model) {
		if (!bindingResult.hasErrors()) {
			if(reportGeneralDTO.getTypeOfTesting().equals(TypeOfTesting.VT)){
				VisualReportDTO visualReportDTO = new VisualReportDTO();
				visualReportDTO.setCustomerId(reportGeneralDTO.getCustomerId());
				visualReportDTO.setOrderNumber(reportGeneralDTO.getOrderNumber());
				visualReportDTO.setPlace(reportGeneralDTO.getPlace());
				visualReportDTO.setQualityLevel(reportGeneralDTO.getQualityLevel());
				visualReportDTO.setTypeOfTesting(reportGeneralDTO.getTypeOfTesting());
				visualReportDTO.setExaminationDate(reportGeneralDTO.getExaminationDate());
				reportsList.setReportDTO(visualReportDTO);
				model.addAttribute("employess", employeeList);
				model.addAttribute("documents", documentList);
				model.addAttribute("devices", devicesList);
				model.addAttribute("visualReportDetailsDTO", new VisualReportDetailsDTO());
				
				return "reports/add_report/addVisualReport";
			}
			
		}

		model.addAttribute("customers", customersList);
		return "reports/add_report/addReport";
	}

	@RequestMapping("/addVisualResults")
	public String addVisualResults(@Valid @ModelAttribute VisualReportDetailsDTO visualReportDetailsDTO, BindingResult bindingResult,
			Model model) {
		System.out.println("Errory"+bindingResult.getFieldErrorCount());
		if (!bindingResult.hasErrors()) {
			VisualReportDTO visualReportDTO = (VisualReportDTO) reportsList.getReportDTO();
			visualReportDTO.setExaminatedObject(visualReportDetailsDTO.getExaminatedObject());
			visualReportDTO.setTechnicalDocumentList(visualReportDetailsDTO.getTechnicalDocumentList());
			visualReportDTO.setMeasuringEquipmentList(visualReportDetailsDTO.getMeasuringEquipmentList());
			visualReportDTO.setAprover(visualReportDetailsDTO.getAproverEmail());
			visualReportDTO.setPerformer(visualReportDetailsDTO.getPerformerEmail());
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
	
	@RequestMapping("/addExaminationResult")
	public String addExaminationResult(@ModelAttribute ResultOfExaminationDTO resultOfExaminationDTO,Model model){
		resultsList.getResults().add(resultOfExaminationDTO);
		model.addAttribute("resultsOfExaminationDTO", new ResultOfExaminationDTO());
		model.addAttribute("results", resultsList);

		return "reports/add_report/addVisualResults";
	}
	
	@RequestMapping("/saveVisualCertificate")
	public String saveReport(@ModelAttribute ResultOfExaminationDTO resultOfExaminationDTO, Model model){
		
		
		reportService.saveVisualReport();
		
		
		List<ReportDTO> reports = reportService.getAllReports();
		reportsList.setReports(reports);
		model.addAttribute("reports", reportsList);
		return "reports/show_reports/showAllReports";
	
	}
	
}
