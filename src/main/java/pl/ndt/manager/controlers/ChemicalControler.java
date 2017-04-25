package pl.ndt.manager.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.ndt.manager.components.AlertComponent;
import pl.ndt.manager.components.ChemicalsList;
import pl.ndt.manager.model.Chemical;
import pl.ndt.manager.model.enums.Objects;
import pl.ndt.manager.services.ChemicalsService;

@Controller
public class ChemicalControler {

	@Autowired
	private ChemicalsService chemicalsService;
	@Autowired
	private ChemicalsList chemicalsList;
	@Autowired
	private AlertComponent alertComponent;

	/**
	 * Shows list of all Chemicals saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showChemicalss view
	 */
	@GetMapping("/showChemicals")
	public String showAllChemicals(Model model) {

		List<Chemical> chemicals = chemicalsService.getChemicals();
		chemicalsList.setChemicals(chemicals);
		model.addAttribute("chemicals", chemicalsList);

		return "devices/show_devices/showChemicals";
	}

	/**
	 * Shows form to save Chemical in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addChemical view
	 */
	@GetMapping("/addChemical")
	public String addChemical(Model model) {

		model.addAttribute("chemical", new Chemical());

		return "devices/add_device/addChemical";
	}

	/**
	 * Saves new Chemical in System
	 * 
	 * @param chemical
	 *            Chemical object
	 * @param result
	 *            Holder for attributes
	 * @param model
	 * @return addChemical view
	 */

	@PostMapping("/saveChemical")
	public String saveVerification(@Valid @ModelAttribute Chemical chemical, BindingResult result, Model model) {

		if (!result.hasErrors()) {

			String alert = null;
			try {
				chemicalsService.saveChemical(chemical);
			} catch (Exception e) {
				alert = alertComponent.savedUnsucesfully(Objects.CHEMICALS);
				model.addAttribute("alert", alert);
				return "devices/add_device/addChemical";
			}
			alert= alertComponent.savedSucesfully(Objects.CHEMICALS);
			model.addAttribute("alert", alert);
		}
		return "devices/add_device/addChemical";
	}

	/**
	 * Shows form for editing Chemical
	 * 
	 * @param id
	 *            Chemical id
	 * @param model
	 *            Holder for attributes
	 * @return editChemical view
	 */
	@GetMapping("/editChemical")
	public String editProbe(@RequestParam("id") Long id, Model model) {
		List<Chemical> chemicals = chemicalsList.getChemicals();
		Optional<Chemical> optionalChemical = chemicals.stream().filter(a -> (a.getId() == id)).findAny();
		Chemical chemical = optionalChemical.get();

		model.addAttribute("chemical", chemical);

		return "devices/edit_device/editChemical";
	}

	/**
	 * 
	 * Updates chemicals
	 * 
	 * @param chemical
	 *            Chemical object
	 * @param result
	 *            Holder for errors
	 * @param id
	 *            Chemical id
	 * @param model
	 *            Holder for attributes
	 * @return editChemical view
	 */
	@PostMapping("/updateChemical")
	public String updateChemicals(@Valid @ModelAttribute Chemical chemical, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			chemical.setId(id);
			try {
				chemicalsService.saveChemical(chemical);
			} catch (Exception e) {
				alert = alertComponent.updatedUnsucesfully(Objects.CHEMICALS);
				model.addAttribute("alert", alert);
				return "devices/edit_device/editChemical";
			}
			alert = alertComponent.updatedUnsucesfully(Objects.CHEMICALS);
			model.addAttribute("alert", alert);
		}
		return "devices/edit_device/editChemical";
	}
}
