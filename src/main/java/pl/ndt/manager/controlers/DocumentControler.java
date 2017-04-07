package pl.ndt.manager.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.dto.DocumentDTO;

import pl.ndt.manager.dto.NdtCertificateDTO;
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
	 * Shows list of NDT Certificates
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showNdtCertificates view
	 */
	@RequestMapping("/showNdtCertificates")
	public String showNdtCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getNdtCertificates();
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
	@RequestMapping("/showVcaCertificates")
	public String showVcaCertificates(Model model) {
		List<DocumentDTO> documents = documentService.getVcaCertificates();
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
	 * Shows list of Jaeger Tests
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showJaegerTests view
	 */

	@RequestMapping("/showJaegerTests")
	public String showJaegerTests(Model model) {
		List<DocumentDTO> documents = documentService.getJaegerTests();
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "personel/show_docs/showJaegerTests";
	}

	/**
	 * Shows list of Ndt Certificates
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return addNdtCertificate view
	 */

	@RequestMapping("/addNdtCertificate")
	public String addNdtCertificate(Model model) {
		model.addAttribute("ndtCertificateDTO", new NdtCertificateDTO());
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/add_docs/addNdtCertificate";
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

}
