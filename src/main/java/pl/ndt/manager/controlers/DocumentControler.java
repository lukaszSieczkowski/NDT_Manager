package pl.ndt.manager.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.DocumentList;
import pl.ndt.manager.dto.DocumentDTO;
import pl.ndt.manager.services.DocumentService;

@Controller
public class DocumentControler{
	
	@Autowired
	private DocumentList documentList;
	
	@Autowired
	private DocumentService documentService;
	
	/**
	 * Shows list of NDT Certificates
	 * @param model
	 * @return ndtCertificates view
	 */
	@RequestMapping("/showNdtCertificates")
	public String showNdtCertificates(Model model){
		List<DocumentDTO> documents = documentService.getNdtCertificates();
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "ndtCertificates";
	}
	
	
	/**
	 * Shows list of VCA Certificates
	 * @param model
	 * @return vcaCertificates view
	 */
	@RequestMapping("/showVcaCertificates")
	public String showVcaCertificates(Model model){
		List<DocumentDTO> documents = documentService.getVcaCertificates();
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "vcaCertificates";
	}
	
	/**
	 * Shows list of Medical Examinations
	 * @param model
	 * @return medicalExaminations view
	 */
	@RequestMapping("/showMedicalExamination")
	public String showMedicalExamination(Model model){
		List<DocumentDTO> documents = documentService.getMedicalExaminations();
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "medicalExaminations";
	}
	
	/**
	 * Shows list of Jaeger Tests
	 * @param model
	 * @return jaegerTests view
	 */

	@RequestMapping("/showJaegerTests")
	public String showJaegerTests(Model model){
		List<DocumentDTO> documents = documentService.getJaegerTests();
		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "jaegerTests";
	}
}
