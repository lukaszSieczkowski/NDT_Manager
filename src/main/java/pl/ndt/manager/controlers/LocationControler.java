package pl.ndt.manager.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.LocationsList;
import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.services.LocationService;

@Controller
@SessionAttributes("locations")
public class LocationControler {

	@Autowired
	private LocationService locationService;

	@Autowired
	private LocationsList locations;

	/**
	 * Shows list of all Business locations saved in system
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showNdtLocation view
	 */
	@RequestMapping("/showLocations")
	public String showAllLocations(Model model) {
		List<LocationDTO> locationsList = locationService.getLocations();
		locations.setLocations(locationsList);
		model.addAttribute("locations", locations);
		return "locations/show_location/showLocation";

	}

	/**
	 * Shows form to save Business Location in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addLocation view
	 */

	@RequestMapping("/addLocation")
	public String addLocation(Model model) {
		model.addAttribute("locationDTO", new LocationDTO());
		return "locations/add_location/addLocation";
	}

	/**
	 * Saves new Business Location in System
	 * 
	 * @param locationDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addLocation view
	 */

	@PostMapping("/saveLocation")
	public String saveLocation(@Valid @ModelAttribute LocationDTO locationDTO, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			try {
				locationService.saveLocation(locationDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Location wasn't saved successfully";
				model.addAttribute("alert", alert);
				return "locations/add_location/addLocation";
			}
			alert = "Location was saved successfully";
			model.addAttribute("alert", alert);
		}
		return "locations/add_location/addLocation";
	}

	/**
	 * Shows form for editing Business Location
	 * 
	 * @param id
	 *            Business Location id
	 * @param model
	 *            Holder for attributes
	 * @return editLocation view
	 */

	@GetMapping("/editLocation")
	public String editLocation(@RequestParam("id") Long id, Model model) {
		List<LocationDTO> locations = locationService.getLocations();
		Optional<LocationDTO> optionalLocationDTO = locations.stream().filter(a -> (a.getId() == id)).findAny();
		LocationDTO locationDTO = (LocationDTO) optionalLocationDTO.get();

		model.addAttribute("locationDTO", locationDTO);
		return "locations/edit_location/editLocation";
	}

	/**
	 * Updates Business Location
	 * 
	 * @param locationDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param id
	 *            Business Location id
	 * @param model
	 *            Holder for attributes
	 * @return editLocation view
	 */

	@RequestMapping("/updateLocation")
	public String updateLocation(@Valid @ModelAttribute LocationDTO locationDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			locationDTO.setId(id);
			try {
				locationService.saveLocation(locationDTO);
			} catch (Exception e) {
				alert = "Something went wrong. Location wasn't updated successfully";
				model.addAttribute("alert", alert);
				return "locations/edit_location/editLocation";
			}
			alert = "Location was updated successfully";
			model.addAttribute("alert", alert);
		}
		return "locations/edit_location/editLocation";
	}
}
