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
import pl.ndt.manager.dto.PersonalDocumentDTO;
import pl.ndt.manager.dto.TechnicalDocumentDTO;
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
		documents = documents.stream()
				.sorted((a,b) -> (((PersonalDocumentDTO) a).getDocumentIsValid()
				.compareTo(((PersonalDocumentDTO) b).getDocumentIsValid())))
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
		documents = documents.stream()
				.sorted((a,b) -> (((PersonalDocumentDTO) a).getDocumentIsValid()
				.compareTo(((PersonalDocumentDTO) b).getDocumentIsValid())))
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
		documents = documents.stream().sorted((a, b) -> (((PersonalDocumentDTO) a).getDocumentIsValid())
				.compareTo(((PersonalDocumentDTO) b).getDocumentIsValid())).collect(Collectors.toList());
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
		documents = documents.stream()
				.sorted((a,
						b) -> (((PersonalDocumentDTO) a).getDocumentIsValid()
								.compareTo(((PersonalDocumentDTO) b).getDocumentIsValid())))
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
		documents = documents.stream()
				.filter(a -> (((PersonalDocumentDTO) a).getDocumentIsValid() != DocumentIsValid.EXPIRED))
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
		documents = documents.stream()
				.filter(a -> (((PersonalDocumentDTO) a).getDocumentIsValid() != DocumentIsValid.EXPIRED))
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
		documents = documents.stream()
				.filter(a -> (((PersonalDocumentDTO) a).getDocumentIsValid() != DocumentIsValid.EXPIRED))
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
		documents = documents.stream()
				.filter(a -> (((PersonalDocumentDTO) a).getDocumentIsValid() != DocumentIsValid.EXPIRED))
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
		String alert = null;
		try {
			documentService.saveNdtCertificate(ndtCertificateDTO);
		} catch (Exception e) {
			alert = "Something went wrong. NDT Certificate wasn't saved successfully";
			model.addAttribute("alert", alert);
			return "personel/add_docs/addNdtCertificate";
		}
		alert = "NDT Certificate was saved successfully";
		model.addAttribute("alert", alert);

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
		String alert = null;
		try {
			documentService.saveJaegerTest(jaegerTestDTO);
		} catch (Exception e) {
			alert = "Something went wrong. Jaeger Test wasn't saved successfully";
			model.addAttribute("alert", alert);
			return "personel/add_docs/addJaegerTest";
		}
		alert = "Jaeger Test was saved successfully";
		model.addAttribute("alert", alert);
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
		String alert = null;
		try {
			documentService.saveVcaCertificate(vcaCertificateDTO);
		} catch (Exception e) {
			alert = "Something went wrong. VCA Certificate wasn't saved successfully";
			model.addAttribute("alert", alert);
			return "personel/add_docs/addVcaCertificate";
		}
		alert = "VCA Certificate was saved successfully";
		model.addAttribute("alert", alert);

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

		String alert = null;
		try {
			documentService.saveMedicalExamination(medicalExaminationDTO);
		} catch (Exception e) {
			alert = "Something went wrong. Medical Examination wasn't saved successfully";
			model.addAttribute("alert", alert);
			return "personel/add_docs/addMedicalExamination";
		}
		alert = "Medical Examination was saved successfully";
		model.addAttribute("alert", alert);

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
		List<DocumentDTO> documents = documentList.getDocuments();
		Optional<DocumentDTO> optionalNdtCertificateDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		NdtCertificateDTO ndtCertificateDTO = (NdtCertificateDTO) optionalNdtCertificateDTO.get();

		model.addAttribute("ndtCertificateDTO", ndtCertificateDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editNdtCertificate";
	}

	/**
	 * Updates NDT Certificate
	 * 
	 * @param ndtCertificateDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param model
	 *            Holder for attributes
	 * @return editNdtCertificate view
	 */

	@RequestMapping("/updateNdtCertificate")
	public String updateNdtCartificate(@Valid @ModelAttribute NdtCertificateDTO ndtCertificateDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			ndtCertificateDTO.setId(id);
			try {
				documentService.updateNdtCertificate(ndtCertificateDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Location wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "personel/edit_docs/editNdtCertificate";
			}
			alert = "Location was updated successfully";
			model.addAttribute("alert", alert);
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
		
		List<DocumentDTO> documents = documentList.getDocuments();
		Optional<DocumentDTO> optionalJaegerTestDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		JaegerTestDTO jaegerTestDTO = (JaegerTestDTO) optionalJaegerTestDTO.get();

		model.addAttribute("jaegerTestDTO", jaegerTestDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editJaegerTest";
	}

	/**
	 * Updates Jaeger Test
	 * 
	 * @param jaegerTestDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param model
	 *            Holder for attributes
	 * @return editJaegerTest view
	 */
	@RequestMapping("/updateJaegerTest")
	public String updateJaegerTest(@Valid @ModelAttribute JaegerTestDTO jaegerTestDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {

		if (!result.hasErrors()) {
			String alert = null;
			jaegerTestDTO.setId(id);
			try {
				documentService.updateJaegerTest(jaegerTestDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Jaeger Test wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "personel/edit_docs/editJaegerTest";
			}
			alert = "Jaeger Test was updated successfully";
			model.addAttribute("alert", alert);
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
		
		List<DocumentDTO> documents = documentList.getDocuments();
		Optional<DocumentDTO> optionalVcaCertificateDTO = documents.stream().filter(a -> (a.getId() == id)).findAny();
		VcaCertificateDTO vcaCertificateDTO = (VcaCertificateDTO) optionalVcaCertificateDTO.get();

		model.addAttribute("vcaCertificateDTO", vcaCertificateDTO);
		employeeList.setEmployees(employeeService.getAllEmployees());
		model.addAttribute("employess", employeeList);
		return "personel/edit_docs/editVcaCertificate";
	}

	/**
	 * Updates VCA Certificate
	 * 
	 * @param vcaCertificateDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param model
	 *            Holder for attributes
	 * @return editVcaCertificate view
	 */

	@RequestMapping("/updateVcaCertificate")
	public String updateVcaCertificate(@Valid @ModelAttribute VcaCertificateDTO vcaCertificateDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {

		if (!result.hasErrors()) {
			String alert = null;
			vcaCertificateDTO.setId(id);
			try {
				documentService.updateVcaCertificate(vcaCertificateDTO);
			} catch (Exception e) {
				alert = "Something went wrong. VCA Certificate wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "personel/edit_docs/editVcaCertificate";
			}
			alert = "VCA Certificate was updated successfully";
			model.addAttribute("alert", alert);
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
		
		List<DocumentDTO> documents = documentList.getDocuments();
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
	 * 
	 * @param medicalExaminationDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param model
	 *            Holder for attributes
	 * @return editVcaCertificate view
	 */

	@RequestMapping("/updateMedicalExamination")
	public String updateMedicalExamination(@Valid @ModelAttribute MedicalExaminationDTO medicalExaminationDTO,
			BindingResult result, @RequestParam("id") Long id, Model model) {

		if (!result.hasErrors()) {
			String alert = null;
			medicalExaminationDTO.setId(id);

			try {
				documentService.updateMedicalExamination(medicalExaminationDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Medical Examination wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "personel/edit_docs/editMedicalExamination";
			}
			alert = "Medical Examination was updated successfully";
			model.addAttribute("alert", alert);
		}
		return "personel/edit_docs/editMedicalExamination";
	}

	/**
	 * Show list of all Technical Standards saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showNorms view
	 */
	@RequestMapping("/showNorms")
	public String showAllNorms(Model model) {
		List<DocumentDTO> documents = documentService.getTechnicalDocuments();

		documentList.setDocuments(documents);
		
		model.addAttribute("documents", documentList);
		return "technical_docs/show_norm/showNorms";
	}

	/**
	 * Shows form to save Technical Standard in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * @return addNormview
	 */
	@RequestMapping("/addNorm")
	public String addNorm(Model model) {
		model.addAttribute("technicalDocumentDTO", new TechnicalDocumentDTO());
		return "technical_docs/add_norm/addNorm";
	}

	/**
	 * Saves new Technical Standard System
	 * 
	 * @param technicalDocumentDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addNorm view
	 */

	@PostMapping("/saveNorm")
	public String saveNorm(@Valid @ModelAttribute TechnicalDocumentDTO technicalDocumentDTO, BindingResult result,
			Model model) {
		String alert = null;
		try {
			documentService.saveTechnicalDocument(technicalDocumentDTO);
		} catch (Exception e) {
			alert = "Something went wrong. Standard wasn't saved successfully";
			model.addAttribute("alert", alert);
			return "technical_docs/add_norm/addNorm";
		}
		alert = "Standard was saved successfully";
		model.addAttribute("alert", alert);
		return "technical_docs/add_norm/addNorm";
	}

	/**
	 * Shows form for editing Technical Standard
	 * 
	 * @param id
	 *            Technical Standard id
	 * @param model
	 *            Holder for attributes
	 * @return editNorm
	 */
	@RequestMapping("/editNorm")
	public String editTechnicalDocumen(@RequestParam("id") Long id, Model model) {

		List<DocumentDTO> documents = documentService.getTechnicalDocuments();
		Optional<DocumentDTO> optionalTechnicalDocumentDTO = documents.stream().filter(a -> (a.getId() == id))
				.findAny();
		TechnicalDocumentDTO technicalDocumentDTO = (TechnicalDocumentDTO) optionalTechnicalDocumentDTO.get();

		model.addAttribute("technicalDocumentDTO", technicalDocumentDTO);

		return "technical_docs/edit_norm/editNorm";
	}

	/**
	 * Updates Technical Standard
	 * 
	 * @param technicalDocumentDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param model
	 *            Holder for attributes
	 * @return editNorm view
	 */

	@RequestMapping("/updateNorm")
	public String updateTechnicalDocument(@Valid @ModelAttribute TechnicalDocumentDTO technicalDocumentDTO,
			BindingResult result, @RequestParam("id") Long id, Model model) {

		if (!result.hasErrors()) {
			String alert = null;
			technicalDocumentDTO.setId(id);

			try {
				documentService.updateTechnicalDocument(technicalDocumentDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Standard wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "technical_docs/edit_norm/editNorm";
			}
			alert = "Standard was updated successfully";
			model.addAttribute("alert", alert);
		}
		return "technical_docs/edit_norm/editNorm";
	}

	/**
	 * Shows list of all Technical Standards to select witch one will be deleted
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return deleteNorm
	 */
	@RequestMapping("/removeNorm")
	public String remove(Model model) {
		List<DocumentDTO> documents = documentService.getTechnicalDocuments();

		documentList.setDocuments(documents);
		model.addAttribute("documents", documentList);
		return "technical_docs/delete_norm/deleteNorm";
	}

	/**
	 * Deletes selected Technical Document
	 * 
	 * @param id
	 *            Technical Document id
	 * @param model
	 *            Holder for attributes
	 * @return showNorms
	 */
	@RequestMapping("/deleteNorm")
	public String editTDeleteNorm(@RequestParam("id") Long id, Model model) {
		String alert = null;
		documentService.deleteTechnicalDocument(id);
		List<DocumentDTO> documents = documentService.getTechnicalDocuments();
		documentList.setDocuments(documents);

		alert = "Standard was deleted successfully";
		model.addAttribute("alert", alert);
		model.addAttribute("documents", documentList);

		return "technical_docs/show_norm/showNorms";
	}
}
