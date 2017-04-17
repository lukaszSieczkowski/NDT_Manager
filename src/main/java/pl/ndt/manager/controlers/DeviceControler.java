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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.DevicesList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.components.LocationsList;
import pl.ndt.manager.dto.DeviceDTO;

import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;
import pl.ndt.manager.dto.ProbeDTO;
import pl.ndt.manager.services.DeviceService;
import pl.ndt.manager.services.EmployeeService;
import pl.ndt.manager.services.LocationService;

@Controller
@SessionAttributes({ "employess", "locations" })
public class DeviceControler {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private DevicesList devicesList;
	@Autowired
	private LocationsList locationsList;

	/**
	 * Shows list of Measuring Devices
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMeasuringEquipment view
	 */
	@RequestMapping("/showMeasuringDevices")
	public String showAllDevices(Model model) {

		List<DeviceDTO> devices = deviceService.getMeasuringEqupiment();
		devicesList.setDevices(devices);
		model.addAttribute("devices", devicesList);

		return "devices/show_devices/showMeasuringEquipment";
	}

	/**
	 * Shows form to save Measuring Device in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addMeasuringEquipment view
	 */
	@RequestMapping("/adddMeasuringDevice")
	public String addDevice(Model model) {

		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		model.addAttribute("locations", locationsList);
		model.addAttribute("measuringEquipmentDTO", new MeasuringEquipmentDTO());

		return "devices/add_device/addMeasuringEquipment";
	}

	/**
	 * Saves new Measuring Device in System
	 * 
	 * @param measuringEquipmentDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addMeasuringEquipmen view
	 */
	@RequestMapping("/saveMeasuringDevice")
	public String saveDevice(@Valid @ModelAttribute MeasuringEquipmentDTO measuringEquipmentDTO, BindingResult result,
			Model model) {

		if (!result.hasErrors()) {
			String alert = null;
			try {
				deviceService.saveDevice(measuringEquipmentDTO);
			} catch (Exception e) {
				alert = "Something was wrong. Device wasn't saved successfully";
				model.addAttribute("alert", alert);
				return "devices/add_device/addMeasuringEquipment";
			}
			alert = "Device was saved successfully";
			model.addAttribute("alert", alert);
		}
		return "devices/add_device/addMeasuringEquipment";

	}

	/**
	 * Shows list of Probes
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMeasuringEquipment view
	 */
	@RequestMapping("/showProbes")
	public String showAllProbes(Model model) {

		List<DeviceDTO> devices = deviceService.getProbes();
		devicesList.setDevices(devices);
		model.addAttribute("devices", devicesList);

		return "devices/show_devices/showProbes";
	}

	/**
	 * Shows form to save Probe in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addProbe view
	 */

	@RequestMapping("/addProbe")
	public String addLocation(Model model) {
		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		model.addAttribute("locations", locationsList);
		model.addAttribute("probeDTO", new ProbeDTO());
		return "devices/add_device/addProbe";
	}

	@RequestMapping("/saveProbe")
	public String saveProbe(@Valid @ModelAttribute ProbeDTO probeDTO, BindingResult result, Model model) {
		System.out.println("Errors"+result.getErrorCount());
		if (!result.hasErrors()) {
			
			String alert = null;
			try {
				deviceService.saveProbe(probeDTO);
			} catch (Exception e) {
				alert = "Something was wrong. Probe wasn't saved successfully";
				model.addAttribute("alert", alert);
				return "devices/add_device/addProbe";
			}
			alert = "Probe was saved successfully";
			model.addAttribute("alert", alert);
		}
		return "devices/add_device/addProbe";
	}
	
	/**
	 * Shows form for editing Probe
	 * 
	 * @param id
	 *            Probe id
	 * @param model
	 *            Holder for attributes
	 * @return editLocation view
	 */

	@GetMapping("/editProbe")
	public String editProbe(@RequestParam("id") Long id, Model model) {
		List<DeviceDTO> devices = devicesList.getDevices();
		Optional<DeviceDTO> optionalDeviceDTO =	devices.stream().filter(a -> (a.getId() == id)).findAny();
		DeviceDTO probeDTO =  optionalDeviceDTO.get();
		
		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		model.addAttribute("locations", locationsList);
		
		model.addAttribute("probeDTO", probeDTO);
		
		return "devices/edit_device/editProbe";
	}

	/**
	 * Updates Probe
	 * 
	 * @param probeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param result
	 *            Holder for errors
	 * @param id
	 *            Probe id
	 * @param model
	 *            Holder for attributes
	 * @return editProbe view
	 */

	@RequestMapping("/updateProbe")
	public String updateProbe(@Valid @ModelAttribute ProbeDTO probeDTO, BindingResult result,
			@RequestParam("id") Long id, Model model) {
		if (!result.hasErrors()) {
			String alert = null;
			probeDTO.setId(id);
			try {
				deviceService.saveProbe(probeDTO);
			} catch (Exception e) {
				alert = "Something was wrong. Probe wasn't updated successfully";
				model.addAttribute("alert", alert);
				 return "devices/edit_device/editProbe";
			}
			alert = "Probe was updated successfully";
			model.addAttribute("alert", alert);
		}
		 return "devices/edit_device/editProbe";
	}

}
