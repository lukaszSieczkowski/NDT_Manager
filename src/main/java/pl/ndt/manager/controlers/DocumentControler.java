package pl.ndt.manager.controlers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.JaegerTestDTO;
import pl.ndt.manager.dto.MedicalExaminationDTO;
import pl.ndt.manager.dto.NdtCertificateDTO;
import pl.ndt.manager.dto.VcaCertificateDTO;
import pl.ndt.manager.model.VcaCertificate;
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.services.DocumentService;
import pl.ndt.manager.services.EmployeeService;

@Controller
@SessionAttributes("employess")
public class DocumentControler {

	@Autowired
	private DocumentList documentList;
	@Autowired
	private EmployeeList employeeList;

	@Autowired
	private DocumentService documentService;

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Shows list of all NDT Certificates saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showNdtCertificates view
	 */
	@RequestMapping("/showAllNdtCertificates")
	public String showAllNdtCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getNdtCertificates();
		documents = documents.stream().sorted((a, b) -> (a.getDocumentIsValid().compareTo(b.getDocumentIsValid())))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showNdtCertificates";
	}

	/**
	 * Shows list of VCA Certificates
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showVcaCertificates view
	 */
	@RequestMapping("/showAllVcaCertificates")
	public String showAllVcaCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getVcaCertificates();
		documents = documents.stream().sorted((a, b) -> (a.getDocumentIsValid().compareTo(b.getDocumentIsValid())))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showVcaCertificates";
	}

	/**
	 * Show list of all Jaeger Test saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showJaegerTests view
	 */

	@RequestMapping("/showAllJaegerTests")
	public String showAllJaegerTests(Model model) {
		List<DocumentDTO> documents = documentService.getJaegerTests();
		documents = documents.stream().sorted((a, b) -> (a.getDocumentIsValid()).compareTo(b.getDocumentIsValid()))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showJaegerTests";
	}

	/**
	 * Shows list of Medical Examinations
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMedicalExaminations view
	 */
	@RequestMapping("showAllMedicalExaminations")
	public String showMedicalExamination(Model model) {
		List<DocumentDTO> documents = documentService.getMedicalExaminations();
		documents = documents.stream().sorted((a, b) -> (a.getDocumentIsValid().compareTo(b.getDocumentIsValid())))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showMedicalExaminations";
	}

	/**
	 * Shows list of valid Jaeger Tests
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showJaegerTests view
	 */

	@RequestMapping("/showValidJaegerTests")
	public String showValidJaegerTests(Model model) {
		List<DocumentDTO> documents = documentService.getJaegerTests();
		documents = documents.stream().filter(a -> (a.getDocumentIsValid() != DocumentIsValid.EXPIRED))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showJaegerTests";
	}

	/**
	 * Shows list of valid Medical Examinations
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMedicalExaminations view
	 */

	@RequestMapping("/showValidMedicalExaminations")
	public String showValidMedicalExaminations(Model model) {
		List<DocumentDTO> documents = documentService.getMedicalExaminations();
		documents = documents.stream().filter(a -> (a.getDocumentIsValid() != DocumentIsValid.EXPIRED))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showMedicalExaminations";
	}

	/**
	 * Shows list of valid VCA Certificates
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showVcaCertificate view
	 */

	@RequestMapping("/showValidVcaCertificates")
	public String showValidVcaCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getVcaCertificates();
		documents = documents.stream().filter(a -> (a.getDocumentIsValid() != DocumentIsValid.EXPIRED))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showVcaCertificates";
	}

	/**
	 * Shows list of valid NDT Certificates
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showNdtCertificates view
	 */
	@RequestMapping("/showValidNdtCertificates")
	public String showValidNdtCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getNdtCertificates();
		documents = documents.stream().filter(a -> (a.getDocumentIsValid() != DocumentIsValid.EXPIRED))
				.collect(Collectors.toList());
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showNdtCertificates";
	}

	/**
	 * Shows form to save NDT Certificate in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * @return addNdtCertificate view
	 */

	@RequestMapping("/adddNdtCertificate")
	public String addNdtCertificate(Model model) {
		model.addAttribute("ndtCertificateDTO", new NdtCertificateDTO());
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addNdtCertificate";
	}

	/**
	 * Shows form to save Jaeger Test in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * @return addNdtCertificate view
	 */
	@RequestMapping("/addJaegerTest")
	public String addJaegerTest(Model model) {
		model.addAttribute("jaegerTestDTO", new JaegerTestDTO());
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addJaegerTest";
	}

	/**
	 * Shows form to save VCA Certificate in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * @return addVcaCertificate view
	 */

	@RequestMapping("/addVcaCertificate")
	public String addVcaCertificate(Model model) {
		model.addAttribute("vcaCertificateDTO", new VcaCertificateDTO());
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addVcaCertificate";
	}

	/**
	 * Shows form to save Medical Examination in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * @return addMedicalEcamination view
	 */

	@RequestMapping("/addMedicalExamination")
	public String addVMedicalExamination(Model model) {
		model.addAttribute("medicalExaminationDTO", new MedicalExaminationDTO());
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addMedicalExamination";
	}

	/**
	 * Saves new NDT Certificate in System
	 * 
	 * @param ndtCertificateDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addNdtCertificate view
	 */
	@PostMapping("/saveNdtCertificate")
	public String saveNdtCertificate(@Valid @ModelAttribute NdtCertificateDTO ndtCertificateDTO, BindingResult result,
			Model model) {
		if (!result.hasErrors()) {
			documentService.saveNdtCertificate(ndtCertificateDTO);
		}
		return "personel/add_docs/addNdtCertificate";
	}

	/**
	 * Saves new Jaeger Test in System
	 * 
	 * @param jaegerTestDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addJaegerTest view
	 */

	@PostMapping("/saveJaegerTest")
	public String saveJaegerCertificate(@Valid @ModelAttribute JaegerTestDTO jaegerTestDTO, BindingResult result,
			Model model) {
		if (!result.hasErrors()) {
			documentService.saveJaegerTest(jaegerTestDTO);
		}
		return "personel/add_docs/addJaegerTest";
	}

	/**
	 * Saves new VCA Certifice in System
	 * 
	 * @param vcaCertificateDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addVcaCertificate view
	 */

	@PostMapping("/saveVcaCertificate")
	public String saveJaegerCertificate(@Valid @ModelAttribute VcaCertificateDTO vcaCertificateDTO,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			documentService.saveVcaCertificate(vcaCertificateDTO);
		}
		return "personel/add_docs/addVcaCertificate";
	}

	/**
	 * Saves new Medical examination in System
	 * 
	 * @param vcaCertificateDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addMedicalEcamination view
	 */

	@PostMapping("/saveMedicalExamination")
	public String saveMedicalExamination(@Valid @ModelAttribute MedicalExaminationDTO medicalExaminationDTO,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			documentService.saveMedicalExamination(medicalExaminationDTO);
		}
		return "personel/add_docs/addMedicalExamination";
	}

}
