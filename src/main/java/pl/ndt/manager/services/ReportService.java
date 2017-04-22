package pl.ndt.manager.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.components.ReportsList;
import pl.ndt.manager.components.ResultsList;
import pl.ndt.manager.dto.EquipmentDTO;
import pl.ndt.manager.dto.ReportDTO;
import pl.ndt.manager.dto.ReportGeneralDTO;
import pl.ndt.manager.dto.ResultOfExaminationDTO;
import pl.ndt.manager.model.Customer;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Report;
import pl.ndt.manager.model.ResultsOfExamination;
import pl.ndt.manager.model.TechnicalDocument;
import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.QualityLevel;
import pl.ndt.manager.repository.CustomerRepository;
import pl.ndt.manager.repository.EmployeeRepository;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;
import pl.ndt.manager.repository.ReportsRepository;
import pl.ndt.manager.repository.ResultOfExaminationRepository;
import pl.ndt.manager.repository.TechnicalDocumentRepository;
import pl.ndt.manager.utils.DateConverter;

@Service
public class ReportService {

	@Autowired
	private ReportsRepository reportsRepository;
	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	@Autowired
	private TechnicalDocumentRepository technicalDocumentRepository;
	@Autowired
	private ResultOfExaminationRepository resultsOfExaminationRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ResultsList resultsList;
	@Autowired
	private ReportsList reportsList;
	@Autowired
	private EmployeeRepository employeeRepository;

	private DateConverter dateConverter;

	/**
	 * Creates list of Reports
	 * 
	 * @return reportLIst
	 */
	public List<ReportDTO> getAllReports() {

		dateConverter = new DateConverter();

		List<Report> reports = (List<Report>) reportsRepository.findAll();
		List<ReportDTO> reportDTOs = new ArrayList<>();

		for (Report report : reports) {
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setId(report.getId());
			reportDTO.setCustomerName(report.getCustomer().getCustomerName());
			reportDTO.setPlace(report.getPlace());
			reportDTO.setOrderNumber(report.getOrderNumber());
			reportDTO.setQualityLevel(report.getQualityLevel().getValue());
			reportDTO.setTypeOfTesting(report.getTypeOfTesting());
			reportDTO.setReportNumber(report.getReportNumber());
			reportDTO.setExaminatedObject(report.getExaminatedObject());
			reportDTO.setMeasuringEquipment(
					report.getMeasuringEquipment().getName() + " " + report.getMeasuringEquipment().getDeviceCode());
			reportDTO.setTechnicalDocument(
					report.getTechnicalDocument().getNumber() + " " + report.getTechnicalDocument().getTitle());

			reportDTO.setExaminationDate(dateConverter.createDateToString(report.getExaminationDate()));
			reportDTO.setPerformer(report.getPerformer().getFirstName() + " " + report.getPerformer().getLastName());
			reportDTO.setAprover(report.getPerformer().getFirstName() + " " + report.getPerformer().getLastName());

			List<ResultsOfExamination> resultsOfExaminations = resultsOfExaminationRepository.findByReport(report);
			List<ResultOfExaminationDTO> resultOfExaminationDTOs = new ArrayList<>();

			for (ResultsOfExamination resultsOfExamination : resultsOfExaminations) {
				ResultOfExaminationDTO resultOfExaminationDTO = new ResultOfExaminationDTO();
				resultOfExaminationDTO.setElementNumber(resultsOfExamination.getElementNumber());
				resultOfExaminationDTO
						.setDistanceFromReferencePoint(resultsOfExamination.getDistanceFromReferencePoint());
				resultOfExaminationDTO.setIndicationLength(resultsOfExamination.getIndicationLength());
				resultOfExaminationDTO.setImperfectionSymbol(resultsOfExamination.getImperfectionSymbol());
				resultOfExaminationDTO.setRemarks(resultsOfExamination.getRemarks());
				resultOfExaminationDTO.setResult(resultsOfExamination.getResult());
				resultOfExaminationDTOs.add(resultOfExaminationDTO);
				reportDTO.setResultsOfExaminationtsList(resultOfExaminationDTOs);
			}

			reportDTOs.add(reportDTO);

		}
		return reportDTOs;

	}

	public void saveVisualReport() {

		dateConverter = new DateConverter();

		ReportDTO reportDTO = reportsList.getReportDTO();
		Report report = new Report();

		Customer customer = customerRepository.findOne(reportDTO.getCustomerId());
		report.setCustomer(customer);
		String reportNumber = createReportNumber(customer);
		///znajdowanie raportu w bazie///
		
		report.setReportNumber(reportNumber);
		report.setPlace(reportDTO.getPlace());
		report.setOrderNumber(reportDTO.getOrderNumber());
		report.setExaminatedObject(reportDTO.getExaminatedObject());
		report.setTypeOfTesting(reportDTO.getTypeOfTesting());
		report.setIssueDate(LocalDateTime.now());
		report.setIssuedBy("Company");
		report = reportsRepository.findByReportNumber(report.getReportNumber());

		String idEqu = reportDTO.getMeasuringEquipment();
		
		
		MeasuringEquipment measuringEquipment = measuringEquipmentRepository.findOne(Long.parseLong(idEqu));
		report.setMeasuringEquipment(measuringEquipment);
		String idDoc = reportDTO.getTechnicalDocument();
		

		TechnicalDocument technicalDocument = technicalDocumentRepository.findOne(Long.parseLong(idDoc));
		report.setTechnicalDocument(technicalDocument);
		report.setExaminationDate(dateConverter.createDateFromString(reportDTO.getExaminationDate(), 0, 0));
		report.setQualityLevel(QualityLevel.valueOf(reportDTO.getQualityLevel()));

		Employee performer = employeeRepository.findOne(Long.parseLong(reportDTO.getPerformer()));
		report.setPerformer(performer);

		Employee aprover = employeeRepository.findOne(Long.parseLong(reportDTO.getAprover()));
		report.setAprover(aprover);

		ResultsOfExamination resultsOfExamination = new ResultsOfExamination();
		List<ResultsOfExamination> resultsOfExaminations = new ArrayList<>();

		List<ResultOfExaminationDTO> resultOfExaminationDTOs = resultsList.getResults();
		for (ResultOfExaminationDTO resultOfExaminationDTO : resultOfExaminationDTOs) {
			resultsOfExamination.setElementNumber(resultOfExaminationDTO.getElementNumber());
			resultsOfExamination.setDistanceFromReferencePoint(resultOfExaminationDTO.getDistanceFromReferencePoint());
			resultsOfExamination.setIndicationLength(resultOfExaminationDTO.getIndicationLength());
			resultsOfExamination.setImperfectionSymbol(resultOfExaminationDTO.getImperfectionSymbol());
			resultsOfExamination.setRemarks(resultOfExaminationDTO.getRemarks());
			resultsOfExamination.setResult(resultOfExaminationDTO.getResult());
			resultsOfExaminations.add(resultsOfExamination);
		}
		report.setResultsOfExaminationtsList(resultsOfExaminations);

		reportsRepository.save(report);

	}

	public String createReportNumber(Customer customer) {
		List<Report> reportsList = reportsRepository.findByCustomer(customer);
		System.out.println("Reports" + reportsList);
		String reportNumber = customer.getCustomerNumber() + "/34/NDT/" + LocalDateTime.now().getYear() + "/"
				+ (reportsList.size() + 1);
		System.out.println("ReportNumber  " + reportNumber);
		return null;

	}

}
