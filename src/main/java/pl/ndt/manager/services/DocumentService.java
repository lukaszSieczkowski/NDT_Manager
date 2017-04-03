package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.JaegerTestDTO;
import pl.ndt.manager.dto.MedicalExaminationDTO;
import pl.ndt.manager.dto.NdtCertificateDTO;
import pl.ndt.manager.dto.VcaCertificateDTO;

import pl.ndt.manager.model.JaegerTest;
import pl.ndt.manager.model.MedicalExamination;
import pl.ndt.manager.model.NdtCertificate;
import pl.ndt.manager.model.VcaCertificate;

import pl.ndt.manager.repository.JaegerTestRepository;
import pl.ndt.manager.repository.MedicalExaminationRepository;
import pl.ndt.manager.repository.NdtCertificateRepository;
import pl.ndt.manager.repository.VcaCertificateRepository;

@Service
public class DocumentService {

	@Autowired
	private NdtCertificateRepository ndtCertificateRepository;
	@Autowired
	private VcaCertificateRepository vcaCertificateRepository;
	@Autowired
	private MedicalExaminationRepository medicalExaminationRepository;
	@Autowired
	private JaegerTestRepository jaegerTestRepository;

	private List<DocumentDTO> documents;

	/**
	 * Prepares list of all NDT Certificates
	 * 
	 * @return NDT Certificates list
	 */
	public List<DocumentDTO> getNdtCertificates() {

		documents = new ArrayList<>();

		List<NdtCertificate> ndtCertificateList = (List<NdtCertificate>) ndtCertificateRepository.findAll();

		for (NdtCertificate ndtCert : ndtCertificateList) {
			NdtCertificateDTO ndtCertDto = new NdtCertificateDTO();
			ndtCertDto.setIssueDate(ndtCert.getIssueDate());
			ndtCertDto.setExpirationDate(ndtCert.getExpirationDate());
			ndtCertDto.setIssuedBy(ndtCert.getIssuedBy());
			ndtCertDto.setFileName(ndtCert.getFileName());
			ndtCertDto.setOwnerFirstName(ndtCert.getEmployee().getFirstName());
			ndtCertDto.setOwnerLastName(ndtCert.getEmployee().getLastName());
			ndtCertDto.setDocumentNumber(ndtCert.getDocumentNumber());
			ndtCertDto.setSector(ndtCert.getSector());
			ndtCert.setNdtMethod(ndtCert.getNdtMethod());
			documents.add(ndtCertDto);
		}
		return documents;
	}

	/**
	 * Prepares list of all VCA Certificates
	 * 
	 * @return VCA Certificates list
	 */
	public List<DocumentDTO> getVcaCertificates() {
		documents = new ArrayList<>();
		List<VcaCertificate> vcaCertificatelist = (List<VcaCertificate>) vcaCertificateRepository.findAll();

		for (VcaCertificate vcaCert : vcaCertificatelist) {
			VcaCertificateDTO vcaCertDto = new VcaCertificateDTO();
			vcaCertDto.setIssueDate(vcaCert.getIssueDate());
			vcaCertDto.setExpirationDate(vcaCert.getExpirationDate());
			vcaCertDto.setIssuedBy(vcaCert.getIssuedBy());
			vcaCertDto.setFileName(vcaCert.getFileName());
			vcaCertDto.setOwnerFirstName(vcaCert.getEmployee().getFirstName());
			vcaCertDto.setOwnerLastName(vcaCert.getEmployee().getLastName());
			vcaCertDto.setDocumentNumber(vcaCert.getDocumentNumber());
			documents.add(vcaCertDto);
		}
		return documents;
	}

	/**
	 * Prepares list of all Medical certificates
	 * 
	 * @return Medical Certificates list
	 */
	public List<DocumentDTO> getMedicalExaminations() {
		documents = new ArrayList<>();
		List<MedicalExamination> medicalCertificateList = (List<MedicalExamination>) medicalExaminationRepository
				.findAll();

		for (MedicalExamination medCert : medicalCertificateList) {
			MedicalExaminationDTO medCertDto = new MedicalExaminationDTO();
			medCertDto.setIssueDate(medCert.getIssueDate());
			medCertDto.setExpirationDate(medCert.getExpirationDate());
			medCertDto.setIssuedBy(medCert.getIssuedBy());
			medCertDto.setFileName(medCert.getFileName());
			medCertDto.setOwnerFirstName(medCert.getEmployee().getFirstName());
			medCertDto.setOwnerLastName(medCert.getEmployee().getLastName());
			medCertDto.setPositiveResultTest(medCert.getPositiveResultTest());
			medCertDto.setRequirementsDescription(medCert.getRequirementsDescription());
			documents.add(medCertDto);
		}
		return documents;
	}

	/**
	 * Prepares list of all Jaeger Tests
	 * 
	 * @return Jaeger Tests list
	 */
	public List<DocumentDTO> getJaegerTests() {
		documents = new ArrayList<>();

		List<JaegerTest> jaegerTests = (List<JaegerTest>) jaegerTestRepository.findAll();

		for (JaegerTest jaegerTest : jaegerTests) {
			JaegerTestDTO jaegerTestDto = new JaegerTestDTO();
			jaegerTestDto.setIssueDate(jaegerTest.getIssueDate());
			jaegerTestDto.setExpirationDate(jaegerTest.getExpirationDate());
			jaegerTestDto.setIssuedBy(jaegerTest.getIssuedBy());
			jaegerTestDto.setFileName(jaegerTest.getFileName());
			jaegerTestDto.setOwnerFirstName(jaegerTest.getEmployee().getFirstName());
			jaegerTestDto.setOwnerLastName(jaegerTest.getEmployee().getLastName());
			jaegerTestDto.setCorrectEyeCondition(jaegerTest.getCorrectEyeCondition());
			documents.add(jaegerTestDto);
		}
		return documents;
	}

}
