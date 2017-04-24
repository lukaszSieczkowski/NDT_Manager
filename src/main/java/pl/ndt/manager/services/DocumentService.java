package pl.ndt.manager.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.dto.*;
import pl.ndt.manager.model.*;
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.repository.*;

import pl.ndt.manager.utils.DateConverter;
import pl.ndt.manager.utils.FileTool;

@Service
public class DocumentService implements FileDirectory {

	@Autowired
	private NdtCertificateRepository ndtCertificateRepository;
	@Autowired
	private VcaCertificateRepository vcaCertificateRepository;
	@Autowired
	private MedicalExaminationRepository medicalExaminationRepository;
	@Autowired
	private JaegerTestRepository jaegerTestRepository;
	@Autowired
	private TechnicalDocumentRepository technicalDocumentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DocumentList documentList;

	private DateConverter dateConverter;
	private List<DocumentDTO> documents;

	/**
	 * Creates list of all NDT Certificates
	 * 
	 * @return NDT Certificates list
	 */
	public List<DocumentDTO> getNdtCertificates() {

		documents = new ArrayList<>();
		dateConverter = new DateConverter();

		List<NdtCertificate> ndtCertificateList = (List<NdtCertificate>) ndtCertificateRepository.findAll();

		for (NdtCertificate ndtCert : ndtCertificateList) {
			NdtCertificateDTO ndtCertDto = new NdtCertificateDTO();
			ndtCertDto.setId(ndtCert.getId());
			ndtCertDto.setIssueDate(dateConverter.createDateToString(ndtCert.getIssueDate()));
			ndtCertDto.setExpirationDate(dateConverter.createDateToString(ndtCert.getExpirationDate()));
			ndtCertDto.setIssuedBy(ndtCert.getIssuedBy());
			String fileDirectory = UPLOAD_FOLDER + ndtCert.getFileName() + ".pdf";
			ndtCertDto.setFileDirectory(fileDirectory);
			ndtCertDto.setOwnersNameAndSurname(
					ndtCert.getEmployee().getFirstName() + " " + ndtCert.getEmployee().getLastName());
			ndtCertDto.setDocumentNumber(ndtCert.getDocumentNumber());
			ndtCertDto.setSector(ndtCert.getSector());
			ndtCertDto.setNdtMethod(ndtCert.getNdtMethod());
			ndtCertDto.setDocumentIsValid(checkDocumentExpiredDate(ndtCert.getExpirationDate()));
			documents.add(ndtCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all VCA Certificates
	 * 
	 * @return VCA Certificates list
	 */
	public List<DocumentDTO> getVcaCertificates() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<VcaCertificate> vcaCertificatelist = (List<VcaCertificate>) vcaCertificateRepository.findAll();

		for (VcaCertificate vcaCert : vcaCertificatelist) {
			VcaCertificateDTO vcaCertDto = new VcaCertificateDTO();
			vcaCertDto.setId(vcaCert.getId());
			vcaCertDto.setIssueDate(dateConverter.createDateToString(vcaCert.getIssueDate()));
			vcaCertDto.setExpirationDate(dateConverter.createDateToString(vcaCert.getExpirationDate()));
			vcaCertDto.setIssuedBy(vcaCert.getIssuedBy());
			String fileDirectory = UPLOAD_FOLDER + vcaCert.getFileName() + ".pdf";
			vcaCertDto.setFileDirectory(fileDirectory);
			vcaCertDto.setOwnersNameAndSurname(
					vcaCert.getEmployee().getFirstName() + " " + vcaCert.getEmployee().getLastName());
			vcaCertDto.setDocumentNumber(vcaCert.getDocumentNumber());
			vcaCertDto.setDocumentIsValid(checkDocumentExpiredDate(vcaCert.getExpirationDate()));
			documents.add(vcaCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all Medical certificates
	 * 
	 * @return Medical Certificates list
	 */
	public List<DocumentDTO> getMedicalExaminations() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<MedicalExamination> medicalCertificateList = (List<MedicalExamination>) medicalExaminationRepository
				.findAll();

		for (MedicalExamination medCert : medicalCertificateList) {
			MedicalExaminationDTO medCertDto = new MedicalExaminationDTO();
			medCertDto.setId(medCert.getId());
			medCertDto.setIssueDate(dateConverter.createDateToString(medCert.getIssueDate()));
			medCertDto.setExpirationDate(dateConverter.createDateToString(medCert.getExpirationDate()));
			medCertDto.setIssuedBy(medCert.getIssuedBy());
			String fileDirectory = UPLOAD_FOLDER + medCert.getFileName() + ".pdf";
			medCertDto.setFileDirectory(fileDirectory);
			medCertDto.setOwnersNameAndSurname(
					medCert.getEmployee().getFirstName() + " " + medCert.getEmployee().getLastName());

			medCertDto.setRequirementsDescription(medCert.getRequirementsDescription());
			medCertDto.setRequirementsFullFilled(medCert.getRequirementsFullFilled());
			medCertDto.setDocumentIsValid(checkDocumentExpiredDate(medCert.getExpirationDate()));

			documents.add(medCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all Jaeger Tests
	 * 
	 * @return Jaeger Tests list
	 */
	public List<DocumentDTO> getJaegerTests() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<JaegerTest> jaegerTests = (List<JaegerTest>) jaegerTestRepository.findAll();

		for (JaegerTest jaegerTest : jaegerTests) {
			JaegerTestDTO jaegerTestDto = new JaegerTestDTO();
			jaegerTestDto.setId(jaegerTest.getId());
			jaegerTestDto.setExpirationDate(dateConverter.createDateToString(jaegerTest.getExpirationDate()));
			jaegerTestDto.setIssueDate(dateConverter.createDateToString(jaegerTest.getIssueDate()));
			jaegerTestDto.setIssuedBy(jaegerTest.getIssuedBy());
			String fileDirectory = UPLOAD_FOLDER + jaegerTest.getFileName() + ".pdf";
			jaegerTestDto.setFileDirectory(fileDirectory);
			jaegerTestDto.setOwnersNameAndSurname(
					jaegerTest.getEmployee().getFirstName() + " " + jaegerTest.getEmployee().getLastName());
			jaegerTestDto.setCorerctlyEyeCondition(jaegerTest.getCorerctlyEyeCondition());
			jaegerTestDto.setDocumentIsValid(checkDocumentExpiredDate(jaegerTest.getExpirationDate()));
			documents.add(jaegerTestDto);
		}
		return documents;
	}

	/**
	 * Saves new NDT Certificate in System
	 * 
	 * @param ndtCertificateDTO
	 */
	public void saveNdtCertificate(NdtCertificateDTO ndtCertificateDTO) {

		NdtCertificate ndtCertificate = conventDTOtoNDTCertificate(ndtCertificateDTO);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.prepareFileName();
		ndtCertificate.setFileName(fileName);

		fileTool.saveFile(ndtCertificateDTO.getFile(), fileName);

		ndtCertificateRepository.save(ndtCertificate);

	}

	/**
	 * Updates NDT Certificate
	 * 
	 * @param ndtCertificateDTO
	 */

	public void updateNdtCertificate(NdtCertificateDTO ndtCertificateDTO) {

		NdtCertificate ndtCertificate = conventDTOtoNDTCertificate(ndtCertificateDTO);
		Long id = ndtCertificateDTO.getId();
		NdtCertificate tempNdtCert = ndtCertificateRepository.findOne(id);

		String fileName = tempNdtCert.getFileName();
		ndtCertificate.setFileName(fileName);

		FileTool fileTool = new FileTool();
		fileTool.saveFile(ndtCertificateDTO.getFile(), fileName);

		System.out.println("Service " + ndtCertificate);
		ndtCertificateRepository.save(ndtCertificate);

	}

	/**
	 * Convents ndtCertificateDTO to ndtCertificate(Entity)
	 * 
	 * @param ndtCertificateDTO
	 * @return ndtCertificate
	 */

	public NdtCertificate conventDTOtoNDTCertificate(NdtCertificateDTO ndtCertificateDTO) {
		dateConverter = new DateConverter();

		NdtCertificate ndtCertificate = new NdtCertificate();
		ndtCertificate.setId(ndtCertificateDTO.getId());
		ndtCertificate.setIssueDate(dateConverter.createDateFromString(ndtCertificateDTO.getIssueDate(), 0, 0));
		ndtCertificate
				.setExpirationDate(dateConverter.createDateFromString(ndtCertificateDTO.getExpirationDate(), 0, 0));
		ndtCertificate.setIssuedBy(ndtCertificateDTO.getIssuedBy());
		ndtCertificate.setDocumentNumber(ndtCertificateDTO.getDocumentNumber());
		ndtCertificate.setSector(ndtCertificateDTO.getSector());
		ndtCertificate.setNdtMethod(ndtCertificateDTO.getNdtMethod());

		Employee employee = createEmployeeByEmail(ndtCertificateDTO.getEmail());
		ndtCertificate.setEmployee(employee);

		return ndtCertificate;
	}

	/**
	 * Saves new Jaeger Test in database
	 * 
	 * @param ndtCertificateDTO
	 */
	public void saveJaegerTest(JaegerTestDTO jaegerTestDTO) {

		JaegerTest jaegerTest = conventDTOtoJaegerTest(jaegerTestDTO);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.prepareFileName();
		jaegerTest.setFileName(fileName);

		fileTool.saveFile(jaegerTestDTO.getFile(), fileName);

		jaegerTestRepository.save(jaegerTest);

	}

	/**
	 * Updates Jaegert Test in database
	 * 
	 * @param jaegerTestDTO
	 */

	public void updateJaegerTest(JaegerTestDTO jaegerTestDTO) {
		JaegerTest jaegerTest = conventDTOtoJaegerTest(jaegerTestDTO);

		Long id = jaegerTestDTO.getId();
		JaegerTest tempJaegerTest = jaegerTestRepository.findOne(id);

		String fileName = tempJaegerTest.getFileName();
		jaegerTest.setFileName(fileName);

		FileTool fileTool = new FileTool();
		fileTool.saveFile(jaegerTestDTO.getFile(), fileName);

		jaegerTestRepository.save(jaegerTest);

	}

	/**
	 * Convents jaegerTestDTO into jaegerTest(Entity)
	 * 
	 * @param jaegerTestDTO
	 * @return jaegerTest
	 */

	public JaegerTest conventDTOtoJaegerTest(JaegerTestDTO jaegerTestDTO) {
		dateConverter = new DateConverter();
		JaegerTest jaegerTest = new JaegerTest();
		jaegerTest.setId(jaegerTestDTO.getId());
		jaegerTest.setIssueDate(dateConverter.createDateFromString(jaegerTestDTO.getIssueDate(), 0, 0));
		jaegerTest.setExpirationDate(dateConverter.createDateFromString(jaegerTestDTO.getExpirationDate(), 0, 0));
		jaegerTest.setIssuedBy(jaegerTestDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(jaegerTestDTO.getEmail());
		jaegerTest.setEmployee(employee);

		jaegerTest.setCorerctlyEyeCondition(jaegerTestDTO.getCorerctlyEyeCondition());
		return jaegerTest;

	}

	/**
	 * Saves VCA Certificate in System
	 * 
	 * @param vcaCertificateDTO
	 */
	public void saveVcaCertificate(VcaCertificateDTO vcaCertificateDTO) {
		VcaCertificate vcaCertificate = conventDTOtoVcaCertificate(vcaCertificateDTO);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.prepareFileName();
		vcaCertificate.setFileName(fileName);

		fileTool.saveFile(vcaCertificateDTO.getFile(), fileName);

		vcaCertificateRepository.save(vcaCertificate);
	}

	/**
	 * Updates VCA Certificate in database
	 * 
	 * @param vcaCertificateDTO
	 */

	public void updateVcaCertificate(VcaCertificateDTO vcaCertificateDTO) {
		VcaCertificate vcaCertificate = conventDTOtoVcaCertificate(vcaCertificateDTO);

		Long id = vcaCertificateDTO.getId();
		VcaCertificate tempVcaCert = vcaCertificateRepository.findOne(id);

		String fileName = tempVcaCert.getFileName();
		vcaCertificate.setFileName(fileName);

		FileTool fileTool = new FileTool();
		fileTool.saveFile(vcaCertificateDTO.getFile(), fileName);

		vcaCertificateRepository.save(vcaCertificate);

	}

	/**
	 * Convents vcaCertificateDTO into vcaCertificate(Entity)
	 * 
	 * @param vcaCertificateDTO
	 * @return vcaCertificat
	 */

	public VcaCertificate conventDTOtoVcaCertificate(VcaCertificateDTO vcaCertificateDTO) {
		dateConverter = new DateConverter();
		VcaCertificate vcaCertificate = new VcaCertificate();

		vcaCertificate.setId(vcaCertificateDTO.getId());
		vcaCertificate.setIssueDate(dateConverter.createDateFromString(vcaCertificateDTO.getIssueDate(), 0, 0));
		vcaCertificate
				.setExpirationDate(dateConverter.createDateFromString(vcaCertificateDTO.getExpirationDate(), 0, 0));
		vcaCertificate.setDocumentNumber(vcaCertificateDTO.getDocumentNumber());
		vcaCertificate.setIssuedBy(vcaCertificateDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(vcaCertificateDTO.getEmail());
		vcaCertificate.setEmployee(employee);
		return vcaCertificate;
	}

	/**
	 * Saves Medical Examination in system
	 * 
	 * @param medicalExaminationDTO
	 */

	public void saveMedicalExamination(MedicalExaminationDTO medicalExaminationDTO) {

		MedicalExamination medicalExamination = conventDTOtoMedicalExamination(medicalExaminationDTO);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.prepareFileName();
		medicalExamination.setFileName(fileName);

		fileTool.saveFile(medicalExaminationDTO.getFile(), fileName);
		medicalExaminationRepository.save(medicalExamination);

	}

	/**
	 * Updates Medical Examination in database
	 * 
	 * @param medicalExaminationtDTO
	 */

	public void updateMedicalExamination(MedicalExaminationDTO medicalExaminationDTO) {
		MedicalExamination medicalExamination = conventDTOtoMedicalExamination(medicalExaminationDTO);

		Long id = medicalExaminationDTO.getId();
		MedicalExamination tempMedCert = medicalExaminationRepository.findOne(id);

		String fileName = tempMedCert.getFileName();
		medicalExamination.setFileName(fileName);

		FileTool fileTool = new FileTool();
		fileTool.saveFile(medicalExaminationDTO.getFile(), fileName);

		medicalExaminationRepository.save(medicalExamination);

	}

	/**
	 * Convents medicalExaminationDTO into medicalExamination(Entity)
	 * 
	 * @param medicalExaminationDTO
	 * @return medicalExamination
	 */

	public MedicalExamination conventDTOtoMedicalExamination(MedicalExaminationDTO medicalExaminationDTO) {
		dateConverter = new DateConverter();

		MedicalExamination medicalExamination = new MedicalExamination();
		medicalExamination.setId(medicalExaminationDTO.getId());
		medicalExamination.setIssueDate(dateConverter.createDateFromString(medicalExaminationDTO.getIssueDate(), 0, 0));
		medicalExamination
				.setExpirationDate(dateConverter.createDateFromString(medicalExaminationDTO.getExpirationDate(), 0, 0));
		medicalExamination.setIssuedBy(medicalExaminationDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(medicalExaminationDTO.getEmail());
		medicalExamination.setEmployee(employee);

		medicalExamination.setRequirementsDescription(medicalExaminationDTO.getRequirementsDescription());
		medicalExamination.setRequirementsFullFilled(medicalExaminationDTO.getRequirementsFullFilled());
		return medicalExamination;

	}

	/**
	 * Checks if document is still valid
	 * 
	 * @param expiredDate
	 *            Document's expiration date
	 * @return VALID or EXPIRED value
	 */
	public DocumentIsValid checkDocumentExpiredDate(LocalDateTime expiredDate) {

		if (expiredDate.isAfter(LocalDateTime.now())) {
			return DocumentIsValid.VALID;
		} else {
			return DocumentIsValid.EXPIRED;
		}

	}

	/**
	 * Creates Employee by email
	 * 
	 * @param email
	 *            User's email
	 * @return employee
	 */

	public Employee createEmployeeByEmail(String email) {
		User user = userRepository.findByEmail(email);
		Employee employee = user.getEmployee();
		return employee;
	}

	/**
	 * Creates list of all TEchnical Standards
	 * 
	 * @return Technical Standards list
	 */
	public List<DocumentDTO> getTechnicalDocuments() {
		dateConverter = new DateConverter();

		List<TechnicalDocument> technicalDocuments = (List<TechnicalDocument>) technicalDocumentRepository.findAll();
		List<DocumentDTO> technicalDocumnetsDTO = new ArrayList<>();
		for (TechnicalDocument technicalDocument : technicalDocuments) {
			TechnicalDocumentDTO technicalDocumentDTO = new TechnicalDocumentDTO();
			technicalDocumentDTO.setId(technicalDocument.getId());
			technicalDocumentDTO.setIssueDate(dateConverter.createDateToString(technicalDocument.getIssueDate()));
			technicalDocumentDTO.setIssuedBy(technicalDocument.getIssuedBy());
			technicalDocumentDTO.setTypeOfTesting(technicalDocument.getTypeOfTesting());
			technicalDocumentDTO.setNumber(technicalDocument.getNumber());
			technicalDocumentDTO.setTitle(technicalDocument.getTitle());

			String fileDirectory = UPLOAD_FOLDER + technicalDocument.getFileName() + ".pdf";
			technicalDocumentDTO.setFileDirectory(fileDirectory);

			technicalDocumnetsDTO.add(technicalDocumentDTO);
		}
		return technicalDocumnetsDTO;
	}

	/**
	 * Saves Technical Document in system
	 * 
	 * @param technicalDocumentDTO
	 */
	public void saveTechnicalDocument(TechnicalDocumentDTO technicalDocumentDTO) {

		TechnicalDocument technicalDocument = conventDTOtoTechnicalDocumentDTO(technicalDocumentDTO);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.prepareFileName();
		technicalDocument.setFileName(fileName);

		fileTool.saveFile(technicalDocumentDTO.getFile(), fileName);

		technicalDocumentRepository.save(technicalDocument);

	}

	/**
	 * Updates Technical Standard in database
	 * 
	 * @param technicalDocumentDTO
	 */

	public void updateTechnicalDocument(TechnicalDocumentDTO technicalDocumentDTO) {

		TechnicalDocument technicalDocument = conventDTOtoTechnicalDocumentDTO(technicalDocumentDTO);

		Long id = technicalDocumentDTO.getId();
		TechnicalDocument tempTechnicalDocument = technicalDocumentRepository.findOne(id);

		String fileName = tempTechnicalDocument.getFileName();
		technicalDocument.setFileName(fileName);

		FileTool fileTool = new FileTool();
		fileTool.saveFile(technicalDocumentDTO.getFile(), fileName);

		technicalDocumentRepository.save(technicalDocument);

	}

	/**
	 * Convents technicalDocumentDTO into technicalDocument(Entity)
	 * 
	 * @param technicalDocumentDTO
	 * @return technicalDocument
	 */

	public TechnicalDocument conventDTOtoTechnicalDocumentDTO(TechnicalDocumentDTO technicalDocumentDTO) {
		dateConverter = new DateConverter();

		TechnicalDocument technicalDocument = new TechnicalDocument();
		technicalDocument.setId(technicalDocumentDTO.getId());
		technicalDocument.setNumber(technicalDocumentDTO.getNumber());
		technicalDocument.setTitle(technicalDocumentDTO.getTitle());
		technicalDocument.setIssuedBy(technicalDocumentDTO.getIssuedBy());
		technicalDocument.setIssueDate(dateConverter.createDateFromString(technicalDocumentDTO.getIssueDate(), 0, 0));
		technicalDocument.setTypeOfTesting(technicalDocumentDTO.getTypeOfTesting());

		return technicalDocument;
	}

	/**
	 * Deletes selected Technical Standard from database and file system
	 * 
	 * @param id
	 *            Technical Document id;
	 */

	public void deleteTechnicalDocument(Long id) {

		TechnicalDocument technicalDocument = technicalDocumentRepository.findOne(id);
		String fileName = technicalDocument.getFileName();

		FileTool fileTool = new FileTool();
		fileTool.removeFile(fileName);

		technicalDocumentRepository.delete(id);

	}
	
}
