package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.EquipmentDTO;
import pl.ndt.manager.dto.ReportDTO;
import pl.ndt.manager.dto.ResultOfExaminationDTO;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Report;
import pl.ndt.manager.model.ResultsOfExamination;
import pl.ndt.manager.model.TechnicalDocument;
import pl.ndt.manager.model.enums.NdtMethod;
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

	/**
	 * Creates list of Reports
	 * 
	 * @return reportLIst
	 */
	public List<ReportDTO> getAllReports() {

		DateConverter dateConverter = new DateConverter();

		List<Report> reports = (List<Report>) reportsRepository.findAll();
		List<ReportDTO> reportDTOs = new ArrayList<>();

		for (Report report : reports) {
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setId(report.getId());
			reportDTO.setCustomer(report.getCustomer().getCustomerName());
			reportDTO.setReportNumber(report.getReportNumber());
			reportDTO.setPlace(report.getPlace());
			reportDTO.setOrderNumber(report.getOrderNumber());
			reportDTO.setExaminatedObject(report.getExaminatedObject());
			reportDTO.setTypeOfTesting(report.getTypeOfTesting().getValue());

			List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
			List<MeasuringEquipment> measuringEquipments = measuringEquipmentRepository.findByReport(report);

			for (MeasuringEquipment measuringEquipment : measuringEquipments) {
				EquipmentDTO equipmentDTO = new EquipmentDTO();
				equipmentDTO.setName(measuringEquipment.getName());
				equipmentDTO.setModel(measuringEquipment.getModel());
				equipmentDTO.setSerialNumber(measuringEquipment.getSerialNumber());
				equipmentDTOs.add(equipmentDTO);
			}
			reportDTO.setMeasuringEquipmentList(equipmentDTOs);

			List<TechnicalDocument> technicalDocuments = technicalDocumentRepository.findByReport(report);
			List<String> norms = new ArrayList<>();
			for (TechnicalDocument technicalDocument : technicalDocuments) {
				String norm = technicalDocument.getNumber() + " " + technicalDocument.getTitle();
				norms.add(norm);
			}
			reportDTO.setTechnicalDocumentList(norms);

			reportDTO.setExaminationDate(dateConverter.createDateToString(report.getExaminationDate()));
			reportDTO.setQualityLevel(report.getQualityLevel().getValue());
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

}
