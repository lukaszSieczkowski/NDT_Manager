package pl.ndt.manager.controlers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.services.DocumentService;
import pl.ndt.manager.services.EmployeeService;

@Controller
@SessionAttributes({ "employess", "documents" })
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

	/**
	 * Shows form for editing NDT Certificate
	 * 
	 * @param id
	 *            NDT Certificate id
	 * @param model
	 *            Holder for attributes
	 * @return editNdtCertificate view
	 */
	@RequestMapping("/editNdtCertificate")
	public String editNdtCertificate(@RequestParam("id") Long id, Model model) {
		List<DocumentDTO> documents = documentService.getNdtCertificates();
		Optional<DocumentDTO> optionalNdtCertificateDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		NdtCertificateDTO ndtCertificateDTO = (NdtCertificateDTO) optionalNdtCertificateDTO.get();

		model.addAttribute("ndtCertificateDTO", ndtCertificateDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editNdtCertificate";
	}
	/**
	 * Updates NDT Certificate  
	 * @param ndtCertificateDTO Transfer object with values transfered from input form into
	 *            the database
	 * @param result Holder for errors
	 * @param model Holder for attributes
	 * @return editNdtCertificate view
	 */

	@RequestMapping("/updateNdtCertificate")
	public String updateNdtCartificate(@Valid @ModelAttribute NdtCertificateDTO ndtCertificateDTO, BindingResult result,
			Model model) {

		if (!result.hasErrors()) {
			documentService.updateNdtCertificate(ndtCertificateDTO);
		}

		return "personel/edit_docs/editNdtCertificate";
	}

	/**
	 * Shows form for editing Jaeger Test
	 * 
	 * @param id
	 *            Jaeger Test id
	 * @param model
	 *            Holder for attributes
	 * @return editJaegerTest view
	 */
	@RequestMapping("/editJaegerTest")
	public String editJaegerTest(@RequestParam("id") Long id, Model model) {

		List<DocumentDTO> documents = documentService.getJaegerTests();
		Optional<DocumentDTO> optionalJaegerTestDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		JaegerTestDTO jaegerTestDTO = (JaegerTestDTO) optionalJaegerTestDTO.get();

		model.addAttribute("jaegerTestDTO", jaegerTestDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editJaegerTest";
	}

	/**
	 * Updates Jaeger Test 
	 * @param jaegerTestDTO Transfer object with values transfered from input form into
	 *            the database
	 * @param result Holder for errors
	 * @param model Holder for attributes
	 * @return editJaegerTest view
	 */
	@RequestMapping("/updateJaegerTest")
	public String updateJaegerTest(@Valid @ModelAttribute JaegerTestDTO jaegerTestDTO, BindingResult result,
			Model model) {

		if (!result.hasErrors()) {
			documentService.updateJaegerTest(jaegerTestDTO);
		}

		return "personel/edit_docs/editJaegerTest";
	}

	/**
	 * Shows form for editing VCA Certificate
	 * 
	 * @param id
	 *            VCA Certificate id
	 * @param model
	 *            Holder for attributes
	 * @return editVcaCertificate view
	 */
	@RequestMapping("/editVcaCertificate")
	public String editVcaCertificate(@RequestParam("id") Long id, Model model) {

		List<DocumentDTO> documents = documentService.getVcaCertificates();
		Optional<DocumentDTO> optionalVcaCertificateDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		VcaCertificateDTO vcaCertificateDTO = (VcaCertificateDTO) optionalVcaCertificateDTO.get();

		model.addAttribute("vcaCertificateDTO", vcaCertificateDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editVcaCertificate";
	}
	

	/**
	 * Updates VCA Certificate 
	 * @param vcaCertificateDTO Transfer object with values transfered from input form into
	 *            the database
	 * @param result Holder for errors
	 * @param model Holder for attributes
	 * @return editVcaCertificate view
	 */

	@RequestMapping("/updateVcaCertificate")
	public String updateVcaCertificate(@Valid @ModelAttribute VcaCertificateDTO vcaCertificateDTO, BindingResult result,
			Model model) {

		if (!result.hasErrors()) {
			documentService.updateVcaCertificate(vcaCertificateDTO);
		}

		return "personel/edit_docs/editVcaCertificate";
	}

	/**
	 * Shows form for editing Medical Examination
	 * 
	 * @param id
	 *            Medical Examination id
	 * @param model
	 *            Holder for attributes
	 * @return editMedicalExaminationview
	 */

	@RequestMapping("/editMedicalExamination")
	public String editMedicalExamination(@RequestParam("id") Long id, Model model) {

		List<DocumentDTO> documents = documentService.getMedicalExaminations();
		Optional<DocumentDTO> optionalMedicalExaminationDTO = documents.stream().filter(a -> (a.getId() == id))
				.findAny();
		MedicalExaminationDTO medicalExaminationDTO = (MedicalExaminationDTO) optionalMedicalExaminationDTO.get();

		model.addAttribute("medicalExaminationDTO", medicalExaminationDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editMedicalExamination";
	}
	/**
	 * Updates Medical Examination 
	 * @param medicalExaminationDTO Transfer object with values transfered from input form into
	 *            the database
	 * @param result Holder for errors
	 * @param model Holder for attributes
	 * @return editVcaCertificate view
	 */

	@RequestMapping("/updateMedicalExamination")
	public String updateMedicalExamination(@Valid @ModelAttribute MedicalExaminationDTO medicalExaminationDTO,
			BindingResult result, Model model) {

		if (!result.hasErrors()) {
			documentService.updateMedicalExamination(medicalExaminationDTO);
		}

		return "personel/edit_docs/editMedicalExamination";
	}
}
