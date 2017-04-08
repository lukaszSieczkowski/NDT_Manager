package pl.ndt.manager.controlers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.dto.JaegerTestDTO;
import pl.ndt.manager.dto.NdtCertificateDTO;
import pl.ndt.manager.dto.VcaCertificateDTO;
import pl.ndt.manager.model.VcaCertificate;
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.services.DocumentService;
import pl.ndt.manager.services.EmployeeService;

@Controller
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
	 * Shows list of Medical Examinations
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMedicalExaminations view
	 */
	@RequestMapping("showMedicalExaminations")
	public String showMedicalExamination(Model model) {
		List<DocumentDTO> documents = documentService.getMedicalExaminations();
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
	public String saveNdtCertificate(@ModelAttribute NdtCertificateDTO ndtCertificateDTO, Model model) {
		documentService.saveNdtCertificate(ndtCertificateDTO);
		model.addAttribute("employess", employeeList);
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
	public String saveJaegerCertificate(@ModelAttribute JaegerTestDTO jaegerTestDTO, Model model) {
		System.out.println(jaegerTestDTO);
		documentService.saveJaegerTest(jaegerTestDTO);
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addJaegerTest";
	}

	/**
	 * Saves new VCA Certifice in System
	 * 
	 * @param jaegerTestDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addVcaCertificate view
	 */

	@PostMapping("/saveVcaCertificate")
	public String saveJaegerCertificate(@ModelAttribute VcaCertificateDTO vcaCertificateDTO, Model model) {
		documentService.saveVcaCertificate(vcaCertificateDTO);
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addVcaCertificate";
	}

}
